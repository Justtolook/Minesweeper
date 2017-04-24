/*
	Name: Henrik Lammert
	Klasse: IF1A
	Gruppe: A
	Datum: 24 Apr 2017
*/

package minesweeper;

import java.awt.Adjustable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

public class StartFenster extends JFrame {
	private double skillLevel;
	static Fenster einFenster;
	JButton b = new JButton("Start");
	
	
	public StartFenster(String title) {
		super(title);
		JScrollBar sb = new JScrollBar(Adjustable.HORIZONTAL,30,10,5,100+9);
		JScrollBar sbSize = new JScrollBar(Adjustable.HORIZONTAL,15,2,2,25+2);
		JLabel tf = new JLabel("" + sb.getValue());
		JLabel tfSize = new JLabel("" + sbSize.getValue());
		
		Panel p1 = new Panel();
			p1.setLayout(new BorderLayout());
			p1.add(new Label("Schwierigkeit:"), BorderLayout.PAGE_START);
			p1.add(sb);
			p1.add(tf, BorderLayout.PAGE_END);
		Panel p2 = new Panel();
			p2.setLayout(new GridLayout(3,1));
			p2.add(new Label("Größe:"));
			p2.add(sbSize);
			p2.add(tfSize);
		
		sb.addAdjustmentListener( new AdjustmentListener() {
			@Override public void adjustmentValueChanged( AdjustmentEvent e ) {
			    tf.setText( "" + sb.getValue() );
			  }
			} );
		
		sbSize.addAdjustmentListener( new AdjustmentListener() {
			@Override public void adjustmentValueChanged( AdjustmentEvent e ) {
			    tfSize.setText( "" + sbSize.getValue() );
			  }
			} );
		
		b.addMouseListener(new MouseListener() {
			@Override public void mousePressed(MouseEvent me) {
				if(me.getButton() ==  1) {
					setVisible(false);
					einFenster = new Fenster("Minesweeper", (double)sb.getValue()/100, sbSize.getValue());	//Minesweeper Spielfeld/Fenster erstellen
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		
		this.setLayout(new GridLayout(3,1));
		this.add(p1); 
		this.add(p2);
		this.add(b);
		//this.setSize(500, 200);
		this.setBackground(Color.GRAY);
		this.setSize(400,230);
		this.setVisible(true);
		
	}
}
