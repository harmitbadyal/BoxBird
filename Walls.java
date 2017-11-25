import java.awt.Graphics;

import java.awt.Graphics2D;

import java.awt.Color;

import java.awt.Rectangle;

public class Walls {

	private final int width = 40;
	
	private int heightTop;
	
	private int wallSpaces=80;
	
	private int heightBottom;
	
	private int xPosition=460;
	
	public Walls(int height)
	{
		this.heightTop = height;
		heightBottom = heightTop+wallSpaces;
		moveWalls();
	}
	
	public void moveWalls()
	{
		xPosition--;
	}
	
	public int getxPosition()
	{
		return xPosition;
	}
	
	public int getCenter()
	{
		return xPosition+20;
	}
	
	public void paintWalls(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.PINK);
		g2d.drawRect(xPosition, -10, width, heightTop);
		g2d.drawRect(xPosition,heightBottom,width, 1000);
		g2d.fillRect(xPosition, -10, width, heightTop);
		g2d.fillRect(xPosition,heightBottom,width, 1000);
	}
	
	public Rectangle getBorder1()
	{
		return new Rectangle(xPosition, -10, width, heightTop);
	}
	
	public Rectangle getBorder2()
	{
		return new Rectangle(xPosition,heightBottom,width, 1000);
	}
	
}