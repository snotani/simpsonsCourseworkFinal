import javax.swing.*;
import javax.swing.JOptionPane.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.AbstractAction;
import java.util.Arrays;

public class scoreboard 
{
	JFrame scoreBoard = new JFrame();
	JPanel scores = new JPanel();	//Create a panel
	JPanel input = new JPanel();
	JPanel board = new JPanel();
	FlowLayout flow = new FlowLayout();  //Set a layout
	BorderLayout border = new BorderLayout();
	
	JLabel yourName = new JLabel("Your Name: ");
	JTextField field = new JTextField(20);
	String[] nameList = new String[10];
	
	
	
	public scoreboard()
	{
		scoreBoard.setVisible(true);		//Make it visible
		scoreBoard.setTitle("HIGH SCORES");	//Set a title
		scoreBoard.setSize(475,440);		//Set a size
		scoreBoard.setResizable(true);  //To not resize the window
		scoreBoard.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);	//Close program on exit
		
		input.setLayout(flow);
		input.add(yourName);
		input.add(field);
		
		scoreBoard.setContentPane(board);	
		board.setLayout(border);
		board.add("South", input);
		
		field.addActionListener(EnterPress);
	}
	
	Action EnterPress = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			for (int i=0; i<12; i++)
			{				
				nameList[i] = field.getText();
				System.out.println("Your name is: " + nameList[i]);
				field.setText(null);
				break;
			}
			
			
		}
	};
	
	
}
