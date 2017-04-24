/*
	Name:	Henrik Lammert
	Klasse: IF2A
	Gruppe: B
	Datum:	07.03.2017
*/
package minesweeper;
import java.awt.*;
import java.awt.event.*;

public class MyWindowListener extends WindowAdapter
{
	private boolean ende;
	
	//Konstruktoren
	public MyWindowListener (boolean ende)
	{
		this.ende = ende;
	}
	
	public MyWindowListener ()
	{
		this.ende = false;
	}
	
	public void windowClosing (WindowEvent event)
	{
		event.getWindow().setVisible(false);		//Fenster unsichtbar
		event.getWindow().dispose();				//Fenster entsorgen
		if (ende)
		{
			System.exit(0);
		}
	}
}