/*
	Name:	Henrik Lammert
	Klasse: IF2A
	Gruppe: B
	Datum:	21.03.2017
*/
package minesweeper;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MyMouseListener extends MouseAdapter
{
	public void mousePressed(MouseEvent me) {
		if(me.getButton() == 3) 	//Rechtsklick -> mit Flagge markieren
		{
			if(((MyJButton)me.getSource()).getFlagged()==false &&
					((MyJButton)me.getSource()).getHidden()==true) {
				((MyJButton)me.getSource()).setFlagged(true);
				((MyJButton)me.getSource()).checkWin();
				((MyJButton)me.getSource()).decreaseMines();
			}
			else {
				((MyJButton)me.getSource()).setFlagged(false);
				((MyJButton)me.getSource()).encreaseMines();
			}
		}
		if(me.getButton() == 1) 
		{
			((MyJButton)me.getSource()).setHidden(false);
			((MyJButton)me.getSource()).checkWin();
			if(((MyJButton)me.getSource()).getMine()) {
				JOptionPane.showMessageDialog(null, "Verloren!");
				System.exit(0);
			}
		}
	}
}
