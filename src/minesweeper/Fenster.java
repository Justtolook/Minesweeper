/*
	Name:	Henrik Lammert
	Klasse: IF2A
	Gruppe: B
	Datum:	14.03.2017
*/
package minesweeper;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Fenster extends JFrame implements ActionListener
{
	private int iSpalten = 15;
	private int iZeilen = 15;
	private int iMines = 0;
	private int Time = 0;
	private double skillLevel = 0.1;
	private JLabel time = new JLabel("");
	private JLabel mines = new JLabel(""); 
	MyJButton[] b;
	
	public Fenster(String title, double skill, int size) {
		super(title);
		skillLevel = skill;
		iSpalten = size;
		iZeilen = size;
		
		b = new MyJButton[iSpalten*iZeilen];
		
		Panel p1 = new Panel();
			p1.setLayout(new GridLayout(1,5));
			p1.add(new Label ("Zeit:"));
			p1.add(time);
			p1.add(new Label ("Minen: "));
			p1.add(mines);
			
		Panel p2 = new Panel();
			p2.setLayout(new GridLayout(iSpalten, iZeilen));
			
			
		for(int iC = 0; iC < iSpalten*iZeilen; iC++) {
			b[iC] = new MyJButton();
			if(skillLevel + Math.random() >=1 ) {
				iMines++;
				b[iC].setMine(true);
				b[iC].setBackgroundColor(Color.blue);
			}
			b[iC].setPreferredSize(new Dimension(48,48));
			b[iC].setBackgroundColor(Color.gray);
			b[iC].setVisible(true);
			b[iC].addActionListener (this);
			b[iC].addMouseListener(new MyMouseListener() {});
		}
		
		
		for(int iC = 0; iC < iSpalten*iZeilen; iC++) {
				if(iC-iSpalten-1>=0 && iC%iSpalten!=0) {
					if(b[iC-iSpalten-1].getMine()==true) b[iC].increaseNeighbours();	//oben links
				}
				if(iC-iSpalten>=0) {
					if(b[iC-iSpalten].getMine()==true) b[iC].increaseNeighbours();		//oben
				}
				if(iC-iSpalten+1>=0 && (iC+1)%iSpalten!=0) {
					if(b[iC-iSpalten+1].getMine()==true) b[iC].increaseNeighbours();	//oben rechts
				}
				if(iC-1>=0 && iC%iSpalten!=0) {
					if(b[iC-1].getMine()==true) b[iC].increaseNeighbours();				//links
				}
				if(iC+1<iSpalten*iZeilen && (iC+1)%iSpalten!=0) {
					if(b[iC+1].getMine()==true) b[iC].increaseNeighbours();				//rechts
				}
				if(iC+iSpalten-1<iSpalten*iZeilen && iC%iSpalten!=0) {
					if(b[iC+iSpalten-1].getMine()==true) b[iC].increaseNeighbours();	//unten links
				}
				if(iC+iSpalten<iSpalten*iZeilen) {
					if(b[iC+iSpalten].getMine()==true) b[iC].increaseNeighbours();		//unten mitte
				}
				if(iC+iSpalten+1<iSpalten*iZeilen && (iC+1)%iSpalten!=0) {
					if(b[iC+iSpalten+1].getMine()==true) b[iC].increaseNeighbours();	//unten rechts
				}			
			p2.add(b[iC]);
		}
		mines.setText(String.valueOf(iMines));
			
		this.setLayout(new BorderLayout());
		this.add ("North", p1); this.add("Center", p2);
		this.setBackground (Color.GRAY);							// Sonstige Fenstereinstellungen
		this.pack();
		this.setVisible (true);
	}
	
	public void checkWin() {
		int opened=0;
		for(int iC = 0; iC < iSpalten*iZeilen; iC++) {
			if(!b[iC].getHidden()) {
				opened++;
			}
		}
		if(opened+iMines==iSpalten*iZeilen) {
			JOptionPane.showMessageDialog(null, "Gewonnen!");
			System.exit(0);
		}
	}
	
	public void decreaseMines() {
		iMines--;
		mines.setText(String.valueOf(iMines));
	}
	
	public void encreaseMines() {
		iMines++;
		mines.setText(String.valueOf(iMines));
	}
	
	public void actionPerformed (ActionEvent e)	 {
		
	}
	
	
	
	
}
