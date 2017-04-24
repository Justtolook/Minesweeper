/*
	Name:	Henrik Lammert
	Klasse: IF2A
	Gruppe: B
	Datum:	21.03.2017
*/
package minesweeper;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyJButton extends JButton
{
	private boolean hidden;
	private boolean flagged;
	private boolean mine;
	private int neighbours;
	private String s;
	
	public MyJButton() 
	{
		super();
		this.hidden=true;
		this.flagged=false;
		this.mine=false;
		this.neighbours=0;
	}
	
	public void setHidden(boolean h) {
		this.hidden = h;
		
		if(this.mine == true) {
			try
			{
				Image img = ImageIO.read(getClass().getResource("/gfx/Mine.png"));
				this.setIcon(new ImageIcon(img));
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			this.setBackground(Color.lightGray);
			if(neighbours>0) {
				s = String.valueOf(neighbours);
				System.out.println("neighbours: " + s);
				this.setLabel(s);
			}
			
		}
	}
	
	public void setFlagged(boolean f) {
		this.flagged = f;
		try
		{
			if(f) {
				Image img = ImageIO.read(getClass().getResource("/gfx/Flag.png"));
				this.setIcon(new ImageIcon(img));
			}
			else {
				this.setIcon(null);
			}
			
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setMine(boolean m) {
		this.mine = m;
	}
	
	public void setNeighbours(int n) {
		this.neighbours = n;
	}
	
	public void increaseNeighbours() {
		this.neighbours++;
	}
	
	public boolean getHidden() {
		return this.hidden;
	}
	
	public boolean getFlagged() {
		return this.flagged;
	}
	
	public boolean getMine() {
		return this.mine;
	}
	
	public int getNeighbours() {
		return this.neighbours;
	}
	
	public void setBackgroundColor(Color c) {
		this.setBackground(c);
	}

	public void checkWin() {
		StartFenster.einFenster.checkWin();
		
	}

	public void decreaseMines() {
		StartFenster.einFenster.decreaseMines();
		
	}

	public void encreaseMines() {
		StartFenster.einFenster.encreaseMines();
		
	}
}
