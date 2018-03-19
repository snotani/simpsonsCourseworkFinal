import javax.swing.*;
import javax.swing.JOptionPane.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.AbstractAction;

public class scoreboard extends sliding implements ActionListener
{
	private JFrame scoreBoard = new JFrame();
	JPanel scores = new JPanel();	//Create a panel
	JPanel input = new JPanel();
	JPanel board = new JPanel();
	FlowLayout flow = new FlowLayout();  //Set a layout
	BorderLayout border = new BorderLayout();
	GridLayout grid = new GridLayout(10,2);
	
	JLabel yourName = new JLabel("Your Name: ");
	JLabel sidd = new JLabel("Siddharth Notani");
	JLabel none2 = new JLabel("None");
	JLabel none3 = new JLabel("None");
	JLabel none4 = new JLabel("None");
	JLabel none5 = new JLabel("None");
	JLabel none6 = new JLabel("None");
	JLabel none7 = new JLabel("None");
	JLabel count1 = new JLabel("500");
	JLabel count2 = new JLabel("0");
	JLabel count3 = new JLabel("0");
	JLabel count4 = new JLabel("0");
	JLabel count5 = new JLabel("0");
	JLabel count6 = new JLabel("0");
	JLabel count7 = new JLabel("0");

	JTextField field = new JTextField(20);
	String[] nameList = new String[10];
	
	
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
			
		field.addActionListener(EnterPress);
		
	}
	
	Action EnterPress = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			String string = Integer.toString(count);
			
			for (int i=0; i<12; i++)
			{			
				nameList[i] = field.getText();
				System.out.println("Name: " + nameList[i] + " Score: " + count);
				none2.setText(nameList[i]);
				count2.setText(string);
				field.setText(null);
				break;
			}
			
			int x=13;

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
			
		}
	};	
}
