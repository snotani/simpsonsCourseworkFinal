import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class randomize extends sliding implements ActionListener
{ 
	private Random random = new Random();
	private List<Integer> numbers = new ArrayList<Integer>();
	
	private int i = 0;
	private int next = random.nextInt(12);
	
	public randomize()
	{
		randomize_2();
		
		if(isSolvable())
			System.out.println("Solvable!");
		else{
			System.out.println("Not solvable!");
			randomize_2();
		}
	}
	
	public boolean isSolvable(){
		int inversions=0;
		for (int z=0; z<10; z++){
			
			if (numbers.get(z+1) < numbers.get(z)){
					inversions++;
			}	
		}
		
		return (inversions%2 == 0);
	}
	
	public void randomize_2 (){
		do {
				int next = random.nextInt(12);
		
					if (!numbers.contains(next)){
						numbers.add(next);
						imageArray[next] = new ImageIcon("bart" + next + ".jpg");
						button[i].setIcon(imageArray[next]);
						i++;
					}
				} while (numbers.size() < 12);
	}
	
	
	
	public void actionPerformed(ActionEvent e){	
	
		int x=15;
	
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
			}
			
			if(newGame == e.getSource()){
				new randomize();
				count = 0;
				score.setText("          Your score: " + count + "          ");
			}
	
	}
}

			