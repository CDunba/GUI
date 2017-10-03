package phase2;


class Hand 
{
   public static final int MAX_CARDS = 56;      

   private Card[] myCards = new Card[MAX_CARDS];
   int numCards = 0;

    void sort()
    {
        Card.arraySort(this.myCards, numCards);
    }
}
