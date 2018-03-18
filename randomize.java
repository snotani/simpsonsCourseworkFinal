import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class randomize extends sliding
{ 
	int n;
	
	public randomize()
	{
		for(int i = 0; i < imageArray.length; i++) {

			n = (int) Math.floor(Math.random()*(12 - 0));
			imageArray[n] = new ImageIcon("bart" + n + ".jpg");
		
		
			button[i].setIcon((imageArray[n])); 
			imageArray[i] = null; 
		}
	}
}

			/*imageArray[i] = new ImageIcon("bart" + i + ".jpg");
			button[i] = new JButton(imageArray[i]);
			button[i].addActionListener(this);
			puzzle.add(button[i]);
			
			temp = imageArray[i];
					imageArray[i] = imageArray[x];
					imageArray[x] = temp;
			
					button[i].setIcon(imageArray[i]);
					button[x].setIcon(imageArray[x]);*/