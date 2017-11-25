
import javax.swing.JFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.WindowConstants;

import java.awt.Graphics;

import java.awt.Graphics2D;

public class EndGame extends JPanel{

private int finalScore;

	
JFrame frame = new JFrame("End Game");

public EndGame(int finalScore)
	{
		this.finalScore = finalScore;
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.add(this);
	}

public void paintComponent(Graphics g)
{
	Graphics2D g2d = (Graphics2D) g;
	Font myFont = new Font("Times New Roman",1,25);
	g2d.setFont(myFont);
	g2d.drawString("Game Over", 180, 200);
	g2d.drawString("Your Final Score: " + finalScore, 135, 250);
}

public void closeEndGame()
{
	frame.dispose();
}
	
}