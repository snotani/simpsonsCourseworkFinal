import javax.swing.*;
import javax.swing.JOptionPane.*;
import java.awt.event.*;
import java.awt.*;

public class scoreboard 
{
	JFrame scoreBoard = new JFrame();
	JPanel scores = new JPanel();	//Create a panel
	JPanel input = new JPanel();
	JPanel board = new JPanel();
	FlowLayout flow = new FlowLayout();  //Set a layout
	BorderLayout border = new BorderLayout();
	
	JLabel name = new JLabel("Your Name: ");
	String placeholder = "Siddharth Notani";
	JTextField field = new JTextField(20);
	
	
	public scoreboard()
	{
		scoreBoard.setVisible(true);		//Make it visible
		scoreBoard.setTitle("HIGH SCORES");	//Set a title
		scoreBoard.setSize(475,440);		//Set a size
		scoreBoard.setResizable(true);  //To not resize the window
		scoreBoard.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);	//Close program on exit
		
		input.setLayout(flow);
		input.add(name);
		input.add(field);
		
		scoreBoard.setContentPane(board);	
		board.setLayout(border);
		board.add("South", input);
	}
}
