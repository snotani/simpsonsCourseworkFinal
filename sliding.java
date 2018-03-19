import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JOptionPane;

public class sliding implements ActionListener
{
	public JFrame frame = new JFrame();	//Create a blank window
	public JPanel panel = new JPanel();
	public JPanel puzzle = new JPanel();	//Create a panel
	public JPanel buttons = new JPanel();
	public GridLayout grid = new GridLayout(3,4);  //Set a layout
	public FlowLayout flow = new FlowLayout();
	public BorderLayout border = new BorderLayout();
	
	public ImageIcon[] imageArray = new ImageIcon[12];
	public ImageIcon temp = new ImageIcon();
	public JButton[] button = new JButton[12];
	
	public int count;
	public JLabel score = new JLabel("          Your score: " + count + "          ");
	public JButton newGame = new JButton("New Game");
	public JButton highScores = new JButton("High Scores");
	
	public sliding()
	{
		puzzle.setLayout(grid);		//Set GridLayout on window

		for(int i=0; i<imageArray.length; i++){
			imageArray[i] = new ImageIcon("bart" + i + ".jpg");
			button[i] = new JButton(imageArray[i]);
			button[i].addActionListener(this);
			puzzle.add(button[i]);
			//new randomize();
		}
		
		buttons.setLayout(flow);
		buttons.add(newGame);
		buttons.add(score);
		buttons.add(highScores);
		newGame.addActionListener(this);
		highScores.addActionListener(this);
		
		frame.setContentPane(panel);	//Use panel on window
		panel.setLayout(border);
		panel.add("North", buttons);
		panel.add("Center", puzzle);
		
		frame.setVisible(true);		//Make it visible
		frame.setTitle("Swingin' Simpsons");	//Set a title
		frame.setSize(475,440);		//Set a size
		frame.setResizable(false);  //To not resize the window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Close program on exit		
		
		
		if (button[0].getIcon().toString().equals("bart0.jpg") && button[1].getIcon().toString().equals("bart1.jpg") && button[2].getIcon().toString().equals("bart2.jpg")
			&& button[3].getIcon().toString().equals("bart3.jpg")&& button[4].getIcon().toString().equals("bart4.jpg")&& button[5].getIcon().toString().equals("bart5.jpg")
			&& button[6].getIcon().toString().equals("bart6.jpg")&& button[7].getIcon().toString().equals("bart7.jpg")&& button[8].getIcon().toString().equals("bart8.jpg")
			&& button[9].getIcon().toString().equals("bart9.jpg")&& button[10].getIcon().toString().equals("bart10.jpg")&& button[11].getIcon().toString().equals("bart11.jpg")){
			JOptionPane.showMessageDialog(null, "Congratulations! The puzzle is solved");
		}

	}
	

	public void actionPerformed(ActionEvent e)
	{	
		int x=13;
	
		for(int i=0; i<imageArray.length; i++)
		{
			if (button[i].getIcon().toString().equals("bart0.jpg"))
			{
				x=i;
				break;
			}
		}
		
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
					
					count ++;
					score.setText("          Your score: " + count + "          ");
					
				}
			}
		}
		
			if(highScores == e.getSource()){
				new scoreboard();
				frame.dispose();
			}
			
			if(newGame == e.getSource()){
				new randomize();
				count = 0;
				score.setText("          Your score: " + count + "          ");
				
			}
			
			if (button[0].getIcon().toString().equals("bart0.jpg") && button[1].getIcon().toString().equals("bart1.jpg") && button[2].getIcon().toString().equals("bart2.jpg")
			&& button[3].getIcon().toString().equals("bart3.jpg")&& button[4].getIcon().toString().equals("bart4.jpg")&& button[5].getIcon().toString().equals("bart5.jpg")
			&& button[6].getIcon().toString().equals("bart6.jpg")&& button[7].getIcon().toString().equals("bart7.jpg")&& button[8].getIcon().toString().equals("bart8.jpg")
			&& button[9].getIcon().toString().equals("bart9.jpg")&& button[10].getIcon().toString().equals("bart10.jpg")&& button[11].getIcon().toString().equals("bart11.jpg")){
				JOptionPane.showMessageDialog(null, "Congratulations! The puzzle is solved");
				new scoreboard();
				frame.dispose();
			}	
	}		
}