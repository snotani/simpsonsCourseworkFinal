import javax.swing.*;
import javax.swing.JOptionPane.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.AbstractAction;

public class scoreboard extends sliding
{
	JFrame scoreBoard = new JFrame();
	JPanel scores = new JPanel();	//Create a panel
	JPanel input = new JPanel();
	JPanel board = new JPanel();
	FlowLayout flow = new FlowLayout();  //Set a layout
	BorderLayout border = new BorderLayout();
	GridLayout grid = new GridLayout(1,2);
	
	JLabel yourName = new JLabel("Your Name: ");
	JLabel sidd = new JLabel("Siddharth N");
	JTextField field = new JTextField(20);
	String[] nameList = new String[10];
	JButton label = new JButton("Name: ");
	
	
	public scoreboard()
	{
		scoreBoard.setVisible(true);		//Make it visible
		scoreBoard.setTitle("High Scores");	//Set a title
		scoreBoard.setSize(475,440);		//Set a size
		scoreBoard.setResizable(false);  //To not resize the window
		scoreBoard.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);	//Close program on exit
		
		input.setLayout(flow);
		input.add(yourName);
		input.add(field);

		scores.setLayout(grid);
		scores.add(sidd);
		
		
		scoreBoard.setContentPane(board);	
		board.setLayout(border);
		board.add("South", input);
		board.add("North", scores);
		
		field.addActionListener(EnterPress);
	}
	
	Action EnterPress = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			for (int i=0; i<12; i++)
			{			
				nameList[i] = field.getText();
				System.out.println("Name: " + nameList[i] + " Score: " );
				field.setText(null);
				break;
			}
				
		}
	};
	
	
}
