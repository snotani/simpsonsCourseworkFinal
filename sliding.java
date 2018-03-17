import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class slidingTiles implements ActionListener
{
	private JFrame frame = new JFrame();	//Create a blank window
	private JPanel panel = new JPanel();	//Create a panel
	private GridLayout layout = new GridLayout(3,4);  //Set a layout
	
	public slidingTiles()
	{
		frame.setVisible(true);		//Make it visible
		frame.setTitle("Swingin' Simpsons");	//Set a title
		frame.setSize(460,400);		//Set a size
		frame.setResizable(false);  //To not resize the window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Close program on exit
		
		frame.setContentPane(panel);	//Use panel on window
		panel.setLayout(layout);		//Set GridLayout on window
	}
	
	
}