/**
* @author Siddharth Notani
* <h1> Simpsons Puzzle - randomize </h1>
* @exception This class randomizes the puzzle when the button newGame is clicked from 
* the main Swing GUI in class sliding. It is extended by class sliding, so it uses it's variables.
*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class randomize extends sliding
{
	/**
	* random is used to randomize an integer in method randomize_2
	* ArrayList numbers contains the list of the numbers that are randomized.
	* ImageIcon randomArray is an array of the random images created.
	*/
	
	private Random random = new Random();
	private List<Integer> numbers = new ArrayList<Integer>();
	
	private ImageIcon[] randomArray = new ImageIcon[12];
	
	private int i = 0;
	private int next = random.nextInt(12);
	
	/**
	* This method is used to randomize the puzzle and check if the puzzle is solvable or not.
	* It randomizes the puzzle; if the puzzle is solvable, it prints Solvable!, else it is randomized again, 
	* until the puzzle is solvable.
	*/
	
	public randomize()
	{
		//While loop was not working
		randomize_2();
		if(isSolvable())
			System.out.println("Solvable!");
	}
	
	/**
	* This method determines if the puzzle is solvable or not.
	* It counts the number of inversions, which are the number of changed numbers.
	* i.e if you imagine the array in a straight line from 0-11, 
	* if the number to the right is less than the number to the left, it is an inversion.
	* Each time this happens, one is added to the variable inversions.
	* If the number of inversions is even, the puzzle is solvable, else it is not solvable.
	*/
	
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
	
	/**
	* This method randomizes the puzzle.
	* It generates a random number with random.nextInt from range 0-11.
	* It stores the number in an ArrayList.
	* This Array then creates an ImageIcon for each number.
	* Each random image is addded onto a button.
	* This occurs for the whole size of the ArrayList, from 0-11
	*/

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
	
	/**
	* Once the images are randomized and set onto each button, the swapping tiles 
	* swap the same way they were swapped in the previous class, just this time with 
	* random images. When the puzzle is solved, a congratulations pop-up appears.
	* The frame still displays the score, newGame and the highScores buttons at the top.
	*/
	
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
				score.setText("          Your score: " + count + "          ");
				
			}
	}
}

			