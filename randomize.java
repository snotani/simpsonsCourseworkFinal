import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class randomize extends sliding
{ 
	private Random random = new Random();
	private List<Integer> numbers = new ArrayList<Integer>();
	
	private ImageIcon[] randomArray = new ImageIcon[12];
	
	private int i = 0;
	private int next = random.nextInt(12);
	
	public randomize()
	{
		//While loop was not working
		randomize_2();
		if(isSolvable())
			System.out.println("Solvable!");
		if(!isSolvable()){
			randomize_2();
			if(isSolvable())
			System.out.println("Solvable!");
		}
		if(!isSolvable()){
			randomize_2();
			if(isSolvable())
			System.out.println("Solvable!");
		}
		if(!isSolvable()){
			randomize_2();
			if(isSolvable())
			System.out.println("Solvable!");
		}
		if(!isSolvable()){
			randomize_2();
			if(isSolvable())
			System.out.println("Solvable!");
		}	
	}
	
	public boolean isSolvable(){
		int inversions=0;
		for (int z=0; z<10; z++){
			if (numbers.get(z+1) < numbers.get(z)){
					inversions++;
					//System.out.println(inversions);
			}	
		}
		
		return (inversions%2 == 0);
	}
	
	public void randomize_2 (){
			do {
					int next = random.nextInt(12);
		
					if (!numbers.contains(next)){
						numbers.add(next);
						randomArray[next] = new ImageIcon("bart" + next + ".jpg");
						button[i].setIcon(randomArray[next]);
						randomArray[i] = randomArray[next];
						//System.out.println(randomArray[i]);
						i++;
					}
				} while (numbers.size() < 12);
				
	}
	
	public void actionPerformed(ActionEvent e){	
	
		int x=13;
	
		for(int i=0; i<12; i++)
		{
			if (button[i].getIcon().toString().equals("bart0.jpg"))
			{
				x=i;
				break;
			}
		}
		
		for(int i=0; i<randomArray.length; i++)
		{
			if(button[i] == e.getSource()){
				if( x ==(i+1) || x ==(i-1) || x ==(i+4) || x ==(i-4))
				{
					temp = randomArray[i];
					randomArray[i] = randomArray[x];
					randomArray[x] = temp;
			
					button[i].setIcon(randomArray[i]);
					button[x].setIcon(randomArray[x]);
					
					count++;
					score.setText("          Your score: " + count + "          ");
					
					if (button[i].getIcon().toString().equals("bart" + i + ".jpg")){
						JOptionPane.showMessageDialog(null, "Congratulations! The puzzle is solved");
						new scoreboard();
					}
					
				}
			}	
		}
			if(highScores == e.getSource()){
					new scoreboard();
					//frame.dispose();
				}
			
			if(newGame == e.getSource()){
				new randomize();
				score.setText("          Your score: " + count + "          ");
				
			}
	}
}

			