package phase1;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Assig5 
{
	static final int NUM_CARD_IMAGES=57;
	static final String values="A23456789TJKQX";
	static final String suites="CDHS";
	static String link; 
	
	static Icon[] icon= new ImageIcon[NUM_CARD_IMAGES];
	
	static void loadCardIcons()
	{
		int iconNumber=0;
		for(int i=0; i<values.length(); i++)
		{
			for(int j=0; j<suites.length(); j++)
			{
				link="images/"+values.charAt(i)+suites.charAt(j)+".gif";
				System.out.println(link);
				icon[iconNumber]=new ImageIcon(link);
				iconNumber++;
			}
		}
		icon[iconNumber]=new ImageIcon("images/BK.gif");
	}
	public static void main(String[] args) 
	{
		int k;

	      // prepare the image icon array
	loadCardIcons();

	      // establish main frame in which program will run
	JFrame frmMyWindow = new JFrame("Card Room");
	frmMyWindow.setSize(1150, 650);
	frmMyWindow.setLocationRelativeTo(null);
	frmMyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	      // set up layout which will control placement of buttons, etc.
	FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 20);   
	frmMyWindow.setLayout(layout);

	      // prepare the image label array
	JLabel[] labels = new JLabel[NUM_CARD_IMAGES];
	      for (k = 0; k < NUM_CARD_IMAGES; k++)
	         labels[k] = new JLabel(icon[k]);

	      // place your 3 controls into frame
	      for (k = 0; k < NUM_CARD_IMAGES; k++)
	frmMyWindow.add(labels[k]);

	      // show everything to the user
	frmMyWindow.setVisible(true);
	   }

}

