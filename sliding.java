import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class slidingTiles implements ActionListener
{
	private JFrame frame = new JFrame();	//Create a blank window
	private JPanel panel = new JPanel();	//Create a panel
	private GridLayout layout = new GridLayout(3,4);  //Set a layout
	
	private ImageIcon[] imageArray = new ImageIcon[12];
	private ImageIcon temp = new ImageIcon();
	private JButton[] button = new JButton[12];
	
	public slidingTiles()
	{
		for(int i=0; i<imageArray.length; i++){
			imageArray[i] = new ImageIcon("bart" + i + ".jpg");
			//imageArray[i] = new ImageIcon(getClass().getResource("bart" + i + ".jpg"));
			button[i] = new JButton(imageArray[i]);
			button[i].addActionListener(this);
			panel.add(button[i]);
		}
		
		frame.setVisible(true);		//Make it visible
		frame.setTitle("Swingin' Simpsons");	//Set a title
		frame.setSize(460,400);		//Set a size
		frame.setResizable(false);  //To not resize the window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Close program on exit
		
		frame.setContentPane(panel);	//Use panel on window
		panel.setLayout(layout);		//Set GridLayout on window
	}
	
	
}