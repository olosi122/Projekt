package Projekt.States;

	import javax.swing.*;

import Projekt.Operation.GamePanel;

import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	class MenuButton extends JButton implements ActionListener {

	    //private GamePanel panel;

	    public MenuButton(String s) {
	        super(s);
	        addActionListener(this);
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        System.out.println("You clicked a button");
	
	    } 
	}


