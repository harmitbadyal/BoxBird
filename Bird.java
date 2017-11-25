import java.awt.event.KeyEvent;

import java.awt.event.MouseEvent;

import java.awt.Graphics;

import java.awt.Graphics2D;

import java.awt.Rectangle;

public class Bird {

	private int yPosition=100;
	private int xPosition=200;
	private final int height=15;
	private final int width=15;
	private int jump;
	private int drop=1;
	
	public Bird()
	{
		
	}	
	
	public void move(int x)
	{
		yPosition+=drop-jump;
		if(x%20==0)
		{
			drop++;
		}
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.fillRect(xPosition, yPosition, height, width);
		g2d.drawRect(xPosition, yPosition, height, width);
	}
	
	public Rectangle getBorder()
	{
		return new Rectangle(xPosition, yPosition, height, width);
	}
	
	public int getCenter()
	{
		return xPosition+8;
	}

	public int getYPosition()
	{
		System.out.println(yPosition+height);
		return yPosition+height;
	}
	
	public void keyPressed(KeyEvent k)
	{
		drop=0;
		jump = 2;
	}
	
	public void keyReleased(KeyEvent k)
	{
             	
	}
	
	public void keyTyped(KeyEvent k)
	{
		
	}

	public void mousePressed(MouseEvent e)
	{
		drop=0;
		jump = 2;
	}

	public void mouseReleased(MouseEvent e)
	{
		
	}
	
	public void mouseTyped(MouseEvent e)
	{
		
	}
}
