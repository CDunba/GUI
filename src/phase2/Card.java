package phase2;
import java.lang.Comparable;

class Card //implements Comparable
{
   public enum Suit{clubs, diamonds, hearts, spades};
    
   private char value;
   private Suit suit;
 
   boolean flag;
    
    public static char[] validCardValues ={'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'X'};
    public static char[] valueRanks = {'C', 'D', 'H', 'S'};
    

    public Card()
    {
        this.set('A', Suit.spades);
    }
     
    public Card(char value, Suit suit)
    {
       this.set(value, suit);
    }
 
  
    public Card(Card card)
    {
       this.set(card.value, card.suit);
    }
  

    public String toString()
    {
       if(this.flag == true)
          return "ERROR";
      else
          return this.value + " of " + suit.toString();         
    } 
    
    public int compareTo(Object testObj)
    {
       int returnValue = -1;

          Card cardObj = (Card)testObj;
          String strRanks = new String(valueRanks);
          
          int val1=strRanks.indexOf(cardObj.getValue());
          int val2=strRanks.indexOf(this.getValue());
          
          if(val1 < 0)
          {
             returnValue = -1;
          }  
          else if(val1 < val2)
          {
             returnValue = -1;
          } 
          else if(val1 == val2)
          {
             returnValue = 0;
          } 
          else if(val1 > val2)
          {
             returnValue = 1;  
          }  
       
        return returnValue; 
    } 

    public boolean equals(Card cardObj)
    {
       if((this.getValue() == cardObj.getValue()) && 
             (this.getSuit() == cardObj.getSuit()))
       {
          return true;
       }
      return false;
       
    } 
    

    public char getValue()
    {
        return value;
    }
 
    
    public Suit getSuit()
    {
        return this.suit;
    }


    static void arraySort(Card[] cards, int arraySize)
    {
        boolean swapped = false;

        do {
            swapped = false;
            for(int i = 1; i < arraySize; i++)
            {
                if(cards[i-1].compareTo(cards[i]) < 0)
                {
                    Card tmpCard = new Card(cards[i-1]);
                    cards[i-1] = new Card(cards[i]);
                    cards[i] = new Card(tmpCard);
                    swapped = true;
                } 
            }
        } while(swapped);
    } 
    
    
    
    private static boolean isValid(char value, Suit suit)
    {
       boolean returnVal = false;
       
       for(int i=0; i<Card.validCardValues.length; i++)
       {
    	   if(value==Card.validCardValues[i])
    	   {
    		   for(int j=0; j<Suit.values().length; j++)
    		   {
    			   if(suit==Suit.values()[j])
    			   {
    				   returnVal=true;
    			   }
    		   }
    	   }
       }
       return returnVal;
    }
    
    public boolean set(char value, Suit suit)
    {
       boolean returnVal = false;
       
       if(Card.isValid(value, suit)) 
        {
            this.flag = false;
            this.value = value;
            this.suit = suit;
            returnVal = true;
        } 
        else
        {
            this.flag = true;
            returnVal = false;
        } 
       
       return returnVal;
    }
    
}
