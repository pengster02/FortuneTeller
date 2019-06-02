/**
 * This program represents a simulation of a fortune teller.
 * Authors: Maria Litvin and Gary Litvin
 * Modified By: Sarah Peng
 * Modified On: May 28th, 2019
 */

//Imports previously created methods and classes.
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.util.Scanner;

//From the list of fortunes, it will display a randomly picked one.
public class FortuneTeller extends JFrame
    implements ActionListener
{
  //Lists out all the possible fortunes.
  private static String[] fortunes = {"Smooth sailing ahead. Have great expectations.", "You will meet someone that will change your life.", 
		  							  "You will soon be rewarded for all your hard work.", "There is a bright future ahead of you.",
		  							  "Stop reminiscing about the past.", "You will meet an important person from the past. ",
		  							  "Your beauty will be recognized one day.", "All your dreams will come true.",
		  							  "Awesome days await you.", "Great accomplishments are coming."};
  private JTextField display;
  
  //Adds the text field and the 'next' button and constructs the Fortune Teller program.
  public FortuneTeller()
  {  
	super("Fortune Teller");

    //Sets the characteristics of the text field.
	Font font = new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16);
	display = new JTextField("  Press \"Next\" to see your fortune...", 30);
    display.setBackground(new Color(255, 127, 0));
    display.setEditable(false);
    display.setFont(font);
    display.setForeground(Color.WHITE);

    //Sets the characteristics of the button.
    JButton go = new JButton("Next");
    go.setBackground(new Color(255, 127, 0));
    go.setFont(font);
    go.setForeground(Color.WHITE);
    go.addActionListener(this);
    
    //Adds the text field and button into the container.
    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    c.setBackground(new Color(255, 165, 0));
    c.add(display);
    c.add(go);
  }
  
  //Called when the button is clicked.
  public void actionPerformed(ActionEvent e)
  {
    //Displays a randomly picked fortune from the list.
	int rdmFortune = (int) (10 * Math.random());
    display.setText("  " + fortunes[rdmFortune]);
  }

  //Paints the crystal ball in the background.
  public void paint(Graphics g)
  {
	  super.paint(g);
	  //Paints the base.
	  g.setColor(new Color (102, 51, 0));
	  int x[] = {180, 130, 370, 320};
	  int y[] = {350, 410, 410, 350};
	  g.fillPolygon(x, y, 4);
	  //Paints the crystal ball.
	  g.setColor(new Color (178, 255, 255));
	  g.fillOval(125, 125, 250, 250);
	  for (int i = 150; i > 100; i -= 10)
	  {
		  g.setColor(new Color (178, 255, 255, i));
		  g.fillOval(250 - (400 - i)/2, 250 - (400 - i)/2, 400 - i, 400 - i);
	  }
	  //Draws 'Fortune Teller' at the bottom.
	  Font font = new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50);
	  g.setColor(Color.WHITE);
	  g.setFont(font);
	  g.drawString("Fortune Teller", 100, 460);
  } 
  
  //Allows the user to see all the possible fortunes and displays 
  public static void main(String[] args)
  {
    //Sets the parameters of the JFrame.
	JFrame window = new FortuneTeller();
	window.setBounds(300, 300, 500, 500);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setResizable(false);
	window.setVisible(true); 
	Scanner kb = new Scanner(System.in);
	String input;
	boolean validEntry;
	
	//Asks the user whether they would like to see all the fortunes or not.
	do
    { 
      System.out.println("Do you want to see the fortunes? Yes/No");
      input = kb.nextLine();
      //Prevents the user from entering any other than Yes or No.
      if (input.equals("Yes") || input.equals("No"))
      {
    	validEntry = true;
    	if (input.equals("Yes"))
    	{
    	  for (int i = 0; i < fortunes.length; i++)
    		System.out.println("" + fortunes[i]);
    	}
      }
      else
      {
    	validEntry = false;
    	System.out.println("INVALID ENTRY. CHOOSE EITHER Yes OR No.");
      }
    }
    while (validEntry == false);  
  }
}
