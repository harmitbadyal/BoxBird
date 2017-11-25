import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.WindowConstants;

import java.awt.Font;

import javax.swing.JOptionPane;

import java.awt.Graphics;

import java.awt.Graphics2D;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;

import java.util.*; 

public class FlappyBird extends JPanel implements KeyListener,MouseListener{
	
private ArrayList <Walls> list = new ArrayList<Walls>();

private JFrame frame = new JFrame("Flappy Bird");

private boolean shouldRun = true;

private int score = 0;

private ArrayList <Bird> birdList = new ArrayList <Bird>();

	public FlappyBird()
	{
		frame.setFocusable(true);
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		frame.addMouseListener(this);
		frame.add(this);
		list.add(new Walls((int)(Math.random()*400)));
		birdList.add(new Bird());
		int counter=0;
		while(shouldRun==true)
		{
			for(int x =0;x<list.size();x++)
			{
				if(list.get(x).getxPosition()==75)
				{
					list.add(new Walls((int)(Math.random()*300)+50));
				}
				if(list.get(x).getxPosition()==0)
				{
					list.remove(x);
				}
			}
			
			counter++;
			birdList.get(0).move(counter);
			
			for(int x =0;x<list.size();x++)
			{
				if(list.get(x).getBorder1().intersects(birdList.get(0).getBorder())||list.get(x).getBorder2().intersects(birdList.get(0).getBorder()))
				{
					shouldRun=false;
					EndGame endGame = new EndGame(score);
					int response = JOptionPane.showConfirmDialog(null,"Play Again?", "Restart", JOptionPane.YES_NO_CANCEL_OPTION);
					if(response==JOptionPane.YES_OPTION)
					{
					endGame.closeEndGame();
					list.clear();
					birdList.clear();
					list.add(new Walls((int)(Math.random()*400)));
					birdList.add(new Bird());
					shouldRun=true;
					score=0;
					}
					else 
					{
					endGame.closeEndGame();
					frame.dispose();
					}
				}
			}
			
			if(birdList.get(0).getYPosition()>465 )
			{
				shouldRun=false;
				EndGame endGame = new EndGame(score);
				int response = JOptionPane.showConfirmDialog(null,"Play Again?", "Restart", JOptionPane.YES_NO_CANCEL_OPTION);
				if(response==JOptionPane.YES_OPTION)
				{
				endGame.closeEndGame();
				list.clear();
				birdList.clear();
				list.add(new Walls((int)(Math.random()*400)));
				birdList.add(new Bird());
				shouldRun=true;
				score=0;
				}
				else 
				{
				endGame.closeEndGame();
				frame.dispose();
				}
			}
			
			for(int x =0; x<list.size();x++)
			{
				if(list.get(x).getCenter()==birdList.get(0).getCenter())
				{
					score++;
				}
			}
			
			repaint();
			try {
                Thread.sleep(6);
            } catch (Exception e){
            }
			
		}
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		birdList.get(0).paint(g);
		Font scoreFont = new Font ("Times New Roman",1,17);
		g2d.setFont(scoreFont);
		g2d.drawString("Score: "+score, 400, 30);
		for(int x =0;x<list.size();x++)
		{
			list.get(x).moveWalls();
			list.get(x).paintWalls(g);
		}
	}
	
	public void keyPressed(KeyEvent k)
	{
		if(k.getKeyCode()==KeyEvent.VK_SPACE)
		{
			birdList.get(0).keyPressed(k);	
		}
	}
	
	public void keyReleased(KeyEvent k)
	{
		birdList.get(0).keyReleased(k);
	}
	
	public void keyTyped(KeyEvent k)
	{
		birdList.get(0).keyTyped(k);
	}
	
	public void mousePressed(MouseEvent e)
	{
		if(e.getButton()==MouseEvent.BUTTON1)
		{
			birdList.get(0).mousePressed(e);
		}
	}
	
	public void mouseReleased(MouseEvent e)
	{
		
	}
	
	public void mouseEntered(MouseEvent e)
	{
		
	}
	
	public void mouseClicked(MouseEvent e)
	{
		
	}
	
	public void mouseExited(MouseEvent e)
	{
		
	}
	
}