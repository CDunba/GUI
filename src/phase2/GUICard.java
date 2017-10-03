package phase2;
import javax.swing.*;
import phase2.GUICard;


class GUICard
{

   private static Icon[][] iconCards = new ImageIcon[14][4];
   private static Icon iconBack = new ImageIcon("./images/BK.gif");
   static boolean iconsLoaded = false;

   
   public static Icon getIcon(Card card)
   {
        if(!GUICard.iconsLoaded)
        {
           GUICard.loadCardIcons();           
        }

        return iconCards[valueAsInt(card)][suitAsInt(card)];
    } 

   public static Icon getBackCardIcon()
   {
       return GUICard.iconBack;
   }
   
   private static int valueAsInt(Card card)
   {
       String values = new String(Card.validCardValues);
       return values.indexOf(card.getValue());
   } 
   
 
   private static int suitAsInt(Card card)
   {
       return card.getSuit().ordinal();
   }

    private static void loadCardIcons()
    {  
       for(int i = 0; i < Card.validCardValues.length; i++)
       {
          for(int j = 0; j < Card.valueRanks.length; j++)
          {
             iconCards[i][j] = new ImageIcon("./images/" + Card.validCardValues[i] + Card.valueRanks[j] + ".gif"); 
          }
       } 
       GUICard.iconsLoaded = true;    
    } 
}