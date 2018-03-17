import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class scoreboard
{
	JFrame scoreBoard = new JFrame();
	JPanel scores = new JPanel();	//Create a panel
	FlowLayout f = new FlowLayout();  //Set a layout
	

	public scoreboard()
	{
		scoreBoard.setVisible(true);		//Make it visible
		scoreBoard.setTitle("HIGH SCORES");	//Set a title
		scoreBoard.setSize(460,400);		//Set a size
		scoreBoard.setResizable(true);  //To not resize the window
		scoreBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Close program on exit
		
		scoreBoard.setContentPane(scores);	//Use panel on window
		scores.setLayout(f);		//Set FlowLayout on window
	}
}
