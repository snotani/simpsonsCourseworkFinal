/**
* @author Siddharth Notani
* <h1> Simpsons Puzzle - sliding </h1>
* @exception This class manages the main GUI of the puzzle. It includes the buttons
* and links to the other classes. It also makes the tiles of the puzzle slide.
*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JOptionPane;

public class sliding implements ActionListener
{
	/**
	* Jframe opens a new window (frame) for the puzzle.
	* JPanel sets a panel that can be used inside the JFrame.
	* There are three panels set, called: panel, which is the main panel,
	* and puzzle & buttons, which are the subpanels inside the main panel; panel.
	* Same thing happens with the layouts. There are three type of layouts; GridLayout, 
	* FlowLayout and BorderLayout. Each panel has its own layout.
	*/
	
	private JFrame frame = new JFrame();	
	private JPanel panel = new JPanel();
	private JPanel puzzle = new JPanel();	
	private JPanel buttons = new JPanel();
	private GridLayout grid = new GridLayout(3,4);  
	private FlowLayout flow = new FlowLayout();
	private BorderLayout border = new BorderLayout();
	
	/** 
	* These variables are used for the adding and swapping of the images.
	* The first variable, of type ImageIcon, called imageArray, is used to store the images of the puzzle.
	* temp, of type ImageIcon, is just a temporary variable that is used for the swapping of images when clicked.
	* button is an array of buttons that is used to add 12 buttons into the puzzle grid.
	*/
	
	private ImageIcon[] imageArray = new ImageIcon[12];
	public ImageIcon temp = new ImageIcon();
	public JButton[] button = new JButton[12];
	
	/**
	* These variables are buttons and labels displayed on the main GUI.
	* JLabel score shows the score of the user when playing the game. The count increases by one everytime a tile is swapped.
	* The button newGame is used to randomize the tiles and start a new game. Similarly, the button highScores is used
	* to show the Leaderboard of the game.
	*/
	
	public int count;
	public JLabel score = new JLabel("          Your score: " + count + "          ");
	public JButton newGame = new JButton("New Game");
	public JButton highScores = new JButton("High Scores");
	
	/**
	* This method sets the main frame and panel of the puzzle.
	* In this first section, each individual part of the array contains an ImageIcon.
	* i.e. imageArray[0] contains the image "bart0.jpg", imageArray[1] contains the image "bart1.jpg".
	* All the corresponding images are added to their corresponding button. Button[0] --> imageArray[0] etc.
	* All these buttons are then added on the panel of the puzzle, in this case the panel "puzzle".
	*/
	
	public sliding()
	{
		for(int i=0; i<imageArray.length; i++){
			imageArray[i] = new ImageIcon("bart" + i + ".jpg");
			button[i] = new JButton(imageArray[i]);
			button[i].addActionListener(this);
			puzzle.add(button[i]);
			//new randomize();
		}
		
		/**
		* Each panel has it's own layout manager set.
		* Panel "buttons", as it's name says, is where all the buttons are placed, in the North of the main panel.
		* Panel "puzzle" is where the puzzle is and has a GridLayout of 3x4. 
		* The main panel, "panel", is the one which decides the position of the other two panels, it has a layout manager of BorderLayout.
		* The two buttons, highScores and newGame have been added with ActionListener's for when they're clicked.
		*/
		
		buttons.setLayout(flow);
		buttons.add(newGame);
		buttons.add(score);
		buttons.add(highScores);
		newGame.addActionListener(this);
		highScores.addActionListener(this);
		
		puzzle.setLayout(grid);	
		
		frame.setContentPane(panel);	
		panel.setLayout(border);
		panel.add("North", buttons);
		panel.add("Center", puzzle);
		
		/**
		* These instructions are used to set the main frame.
		* setVisible sets the window to be visible.
		* setSize sets the size of the window.
		* setResizable is set to false, as we don't want the window to be resized as it can destroy the puzzle.
		* setDefaultCloseOperation is set on "exit on close" so when the window is closed, the program is finished running.
		*/
		
		frame.setVisible(true);		
		frame.setTitle("Swingin' Simpsons");	
		frame.setSize(450,430);		
		frame.setResizable(false); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
	}
	
	/**
	* This method gets the score of the user, which is the number of times they've swapped a tile,
	* and is used in the scoreboard class.
	*/
	
	public int getCount(){
		int count=0;
		count++;
		count=14;
		return count;
	}	
	
	/** 
	* This method is run when a tile is clicked or when a button in the GUI is clicked.
	*/
	
	public void actionPerformed(ActionEvent e)
	{	
		/**
		* The variable x is an integer which does not equal 0-12 as those are the number of images and buttons.
		* If any button in the puzzle finds the image "bart0.jpg" which is the blank image, it will record where that button is.
		*/
	
		int x=13;
	
		for(int i=0; i<imageArray.length; i++)
		{
			if (button[i].getIcon().toString().equals("bart0.jpg"))
			{
				x=i;
				break;
			}
		}
		
		/**
		* This if loop swaps the tiles and also checks to swap the right tiles and not diagonally.
		* If any tile is around (left, right, up or down) the blank tile, it swaps the images of the tiles.
		* Everytime a tile is swapped, variable "count" increases by one and is shown at the top of the GUI.
		* If all buttons in the array equal all images in the array in the correct order, from 0-11, a pop-up 
		* is displayed to show that the puzzle is complete and the Scoreboard is opened.
		*/
		
		for(int i=0; i<imageArray.length; i++)
		{
			if(button[i] == e.getSource()){
				if( x ==(i+1) || x ==(i-1) || x ==(i+4) || x ==(i-4))
				{
					temp = imageArray[i];
					imageArray[i] = imageArray[x];
					imageArray[x] = temp;
			
					button[i].setIcon(imageArray[i]);
					button[x].setIcon(imageArray[x]);
					
					count++;	
					score.setText("          Your score: " + count + "          ");
					
					if (button[i].getIcon().toString().equals("bart" + i + ".jpg")){
						JOptionPane.showMessageDialog(null, "Congratulations! The puzzle is solved");
						new scoreboard();
					}
					
				}
			}
		}
		
			/**
			* If the button highScores on the Swing GUI is clicked, the scoreboard is opened.
			* Similarly, if the button newGame is clicked at the top, the puzzle is randomized and
			* the count at the top is set to it's initial state, zero.
			*/
		
			if(highScores == e.getSource()){
				new scoreboard();
				//frame.dispose();
			}
			
			if(newGame == e.getSource()){
				new randomize();
				count = 0;
				score.setText("          Your score: " + count + "          ");
			}
			
	
	}		
}