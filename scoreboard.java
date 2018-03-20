/**
* @author Siddharth Notani
* <h1> Simpsons Puzzle - scoreboard </h1>
* @exception This class is used to display the scoreboard
*/

import javax.swing.*;
import javax.swing.JOptionPane.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.AbstractAction;

public class scoreboard 
{
	/**
	* JFrame opens a new window which will display the scoreboard.
	* Like the previous window, this frame also has 3 panels. The main one is "board", 
	* and the subpanels are the panels "scores" and "input". Each panel has it's own 
	* layout manager; FlowLayout, GridLayout or BorderLayout.
	*/
	
	sliding s = new sliding();
	private JFrame scoreBoard = new JFrame();
	private JPanel scores = new JPanel();	
	private JPanel input = new JPanel();
	private JPanel board = new JPanel();
	private FlowLayout flow = new FlowLayout();  
	private BorderLayout border = new BorderLayout();
	private GridLayout grid = new GridLayout(10,2);
	
	/**
	* These JLabel's are used to be shown in the scoreboard. These are the Labels set by default.
	* These are changed when Enter is pressed after inputing the user name at the top.
	*/
	
	private JLabel yourName = new JLabel("Your Name: ");
	private JLabel sidd = new JLabel("Siddharth Notani");
	private JLabel none2 = new JLabel("None");
	private JLabel none3 = new JLabel("None");
	private JLabel none4 = new JLabel("None");
	private JLabel none5 = new JLabel("None");
	private JLabel none6 = new JLabel("None");
	private JLabel none7 = new JLabel("None");
	private JLabel count1 = new JLabel("500");
	private JLabel count2 = new JLabel("0");
	private JLabel count3 = new JLabel("0");
	private JLabel count4 = new JLabel("0");
	private JLabel count5 = new JLabel("0");
	private JLabel count6 = new JLabel("0");
	private JLabel count7 = new JLabel("0");

	/**
	* The field is used to get the user input for their name.
	* The string array stores the user name and adds it to the scoreboard when pressed enter.
	*/
	
	private JTextField field = new JTextField(20);
	private String[] nameList = new String[10];
	
	
	public scoreboard()
	{
		/**
		* setVisible is used to display the window.
		* setTitle sets the Title of the window at the top
		* setSize is set as the same size as the main puzzle frame.
		* setDefaultCloseOperation is "Hide on close" so when the window is closed, the main puzzle isn't also closed.
		*/
		
		scoreBoard.setVisible(true);		//Make it visible
		scoreBoard.setTitle("High Scores");	//Set a title
		scoreBoard.setSize(450,430);		//Set a size
		scoreBoard.setResizable(false);  //To not resize the window
		scoreBoard.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);	//Close program on exit
		
		/**
		* There are to subpanels here which are added on to the main panel, board, with a BorderLayout.
		* The subpanel input, which is placed at the top and has a FlowLayout, displays the field for user input.
		* The subpanel scores, placed in the center with GridLayout, adds the Jlabel's set by default.
		*/
		
		input.setLayout(flow);
		input.add(yourName);
		input.add(field);

		scores.setLayout(grid);
		scores.add(sidd);
		scores.add(count1);
		scores.add(none2);
		scores.add(count2);
		scores.add(none3);
		scores.add(count3);
		scores.add(none4);
		scores.add(count4);
		scores.add(none5);
		scores.add(count5);
		scores.add(none6);
		scores.add(count6);
		scores.add(none7);
		scores.add(count7);

		scoreBoard.setContentPane(board);	
		board.setLayout(border);
		board.add("North", input);
		board.add("Center", scores);
		
		/**
		* There is an actionPerformed which is accessed when the Enter key is pressed.
		*/
		
		field.addActionListener(EnterPress);
		
	}
	
	Action EnterPress = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			/**
			* Variable count contains the method from the class sliding which gets the score
			* As JLabel can't be changed to an int, it is then stored in a string.
			* The score is then set in one of the JLabels displayed on the scoreboard.
			* Whatever the user types in the field and pressed Enter, is then stored in an array of String.
			* This text is then set to replace one of the JLabels in the board.
			* Once the user has input something and pressed enter, the field is set back again to null, ready for another input.
			*/
			
			int count = s.getScore();
			String count_string = Integer.toString(count);
			int i=0;
				
			nameList[i] = field.getText();
			//System.out.println("Name: " + nameList[i] + " Score: " + count);
			none2.setText(nameList[i]);
			count2.setText(count_string);
			field.setText(null);
			i++;
		}
	};	
}
