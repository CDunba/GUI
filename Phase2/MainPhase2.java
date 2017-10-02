package phase2;
import java.awt.*;
import javax.swing.*;

public class MainPhase2 
{
 
    static int NUM_CARDS_PER_HAND = 7;
    static int NUM_PLAYERS = 2;
    static final String PLAYER1_NAME = "Computer";
    static final String PLAYER2_NAME = "You";
    public JPanel pnlComputerHand, pnlHumanHand, pnlPlayArea, pnlPlayedCards,
    pnlPlayerText, pnlStatusText;
   
    static JLabel outcome = new JLabel("");
    static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
    static JLabel[] humanLabels = new JLabel[NUM_CARDS_PER_HAND];
    static JLabel[] playedCardLabels = new JLabel[NUM_PLAYERS];
    static JLabel[] playLabelText = new JLabel[NUM_PLAYERS];
    
    
    public static void main(String[] args)
    {
        
        CardTable myCardTable = 
              new CardTable("CardTable",NUM_CARDS_PER_HAND, NUM_PLAYERS);
        
        myCardTable.setSize(800, 600);
        myCardTable.setLocationRelativeTo(null);
        myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


         for(int i = 0; i < NUM_CARDS_PER_HAND; i++)
        {
            computerLabels[i] = new JLabel();
            computerLabels[i].setIcon(GUICard.getBackCardIcon());

            myCardTable.pnlComputerHand.add(computerLabels[i]);
        } 
         
         
         for(int i = 0; i < NUM_CARDS_PER_HAND; i++)
         {          
             humanLabels[i] = new JLabel();
             humanLabels[i].setIcon(GUICard.getIcon(generateRandomCard()));

             myCardTable.pnlHumanHand.add(humanLabels[i]);
         } 
         

      
      //Computer pnlPlayArea Label Settings
      playedCardLabels[0] = new JLabel();
      playedCardLabels[0].setIcon(GUICard.getIcon(generateRandomCard()));
      playedCardLabels[0].setHorizontalAlignment(JLabel.CENTER);
      myCardTable.pnlPlayArea.add(playedCardLabels[0]);
      
      // Computer pnlPlayerText Label Settings
      playLabelText[0] = new JLabel(PLAYER1_NAME + ": 0");
      playLabelText[0].setHorizontalAlignment(JLabel.CENTER);
      playLabelText[0].setVerticalAlignment(JLabel.TOP);
      myCardTable.pnlPlayerText.add(playLabelText[0]);
      myCardTable.pnlPlayArea.add(playLabelText[0]);
      
      //Human pnlPlayArea Label Settings
      playedCardLabels[1] = new JLabel();
      playedCardLabels[1].setIcon(GUICard.getIcon(generateRandomCard()));
      playedCardLabels[1].setHorizontalAlignment(JLabel.CENTER);
      myCardTable.pnlPlayArea.add(playedCardLabels[1]);
      
      // Human pnlPlayerText Label Setting
      playLabelText[1] = new JLabel(PLAYER2_NAME + ": 0");
      playLabelText[1].setHorizontalAlignment(JLabel.CENTER);
      playLabelText[1].setVerticalAlignment(JLabel.TOP);
      myCardTable.pnlPlayerText.add(playLabelText[1]);
      myCardTable.pnlPlayArea.add(playLabelText[1]);
      
      // Result Settings
      outcome.setHorizontalAlignment(JLabel.CENTER);
      myCardTable.pnlStatusText.add(outcome);

      
      
      outcome.setText("");
      outcome.setBorder(null);
        
          
      //myCardTable.setVisible(true);

      /*for(int i = 0; i < NUM_PLAYERS; i++)
      {
         playedCardLabels[i] = new JLabel();
         playedCardLabels[i].setIcon(GUICard.getIcon(generateRandomCard()));
         playLabelText[i] = new JLabel();
         /*if(i == 0)
             playLabelText[i].setText("Computer");
         else
             playLabelText[i].setText("You");
         playedCardLabels[i].setHorizontalAlignment(JLabel.CENTER);
         myCardTable.pnlPlayArea.add(playedCardLabels[i]);
      } 
        
        
      for(JLabel label : playLabelText)
      {
         label.setHorizontalAlignment(JLabel.CENTER);
         myCardTable.pnlPlayArea.add(label);
      }*/
        
      myCardTable.setVisible(true);
    } 
    
    static Card generateRandomCard()
    {
        Card card = new Card();
        int val=Card.validCardValues.length - 1;
        int s=Card.valueRanks.length - 1;
       // System.out.println("value= "+val);
        //System.out.println("Suit= "+s);
        float random=(float) Math.random();
        int value=(int)(random*val);
        float random1=(float) Math.random();
        int suit=(int)(random*s);
       // System.out.println("suit is "+(int)(random*suitt));
        //int value = (int)(Math.random()*(Card.validCardValues.length - 1));
       // int suit = (int)(Math.random()*(Card.validCardSuits.length - 1));
        card.set(Card.validCardValues[value], Card.Suit.values()[suit]);
        return card;
    }
}
