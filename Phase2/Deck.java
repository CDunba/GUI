package phase2;


class Deck
{
    public static final short MAX_CARDS_IN_PACK = 56;
    public static final short MAX_PACKS = 6;
    public static final short MAX_CARDS = MAX_PACKS * MAX_CARDS_IN_PACK;
     
    private static Card[] masterPack = new Card[MAX_CARDS_IN_PACK];
    private Card[] cards; 
    private int topCard; 
    private int numPacks; 
    
    public Deck() 
    {
       this.allocateMasterPack();
       this.init(1);
    } 

    public Deck(int numPacks) 
    {
        
        this.allocateMasterPack();
        
       
        if (numPacks > Deck.MAX_PACKS)
        {
           this.init(Deck.MAX_PACKS);
        }
        else if (numPacks < 1)
        {
           this.init(1); 
        }    
        else
        {   
           this.init(numPacks);     
        } 
    } 
    

    public int getNumCards()
    {
        return this.topCard;
    }


    public int getTopCard() 
    {
        return this.topCard;
    }


    public void init(int numPacks) 
    {
        this.cards = new Card[numPacks * Deck.MAX_CARDS_IN_PACK];

        for (int i = 0; i < numPacks * Deck.MAX_CARDS_IN_PACK; i++) 
        {
            this.cards[i] = this.masterPack[i % Deck.MAX_CARDS_IN_PACK];
        } 

        this.topCard = numPacks * Deck.MAX_CARDS_IN_PACK;
    }

    public void sort()
    {
        Card.arraySort(this.cards, this.topCard);
    }  
    

    public boolean addCard(Card card)
    {
        int cardCount = 0;
        for(Card cardInDeck : this.cards)
        {
           if(cardInDeck.equals(card))
           {
              cardCount++;
           } 
        } 
        
        if((cardCount >= this.numPacks) || 
              (this.topCard >= this.MAX_CARDS))
        {
           return false;
        }
            
        this.topCard++;
        this.cards[topCard - 1] = new Card(card);
        return true;
    } 
    
    private static void allocateMasterPack() 
    {
    	int cardNumber=0;
        if (Deck.masterPack != null) 
        {
           for (int i = 0; i < Card.Suit.values().length; i++) 
           {
              for (int j = 0; j < Card.validCardValues.length; j++) 
              {
            	  Deck.masterPack[cardNumber]=new Card(Card.validCardValues[j], Card.Suit.values()[i]);
            	  cardNumber++;
                } 
            } 
        } 
    } 
    
   public boolean removeCard(Card card)
    {
        for(int i = 0; i < this.cards.length; i++)
        {
           if(this.cards[i].equals(card))
           {
              this.cards[i] = new Card(this.cards[topCard - 1]);
              this.topCard--;
              return true;         
           }         
        }
        return false;
    } 
   
   
   
} 