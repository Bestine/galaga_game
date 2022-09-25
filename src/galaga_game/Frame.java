package galaga_game;

import java.awt.Color;

import javax.swing.JFrame;

public class Frame extends JFrame{
	
	Frame(){
		this.setTitle("Galaga Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.setSize(900, 600);
		this.setVisible(true);
		this.getContentPane().setBackground(Color.BLACK);
	}

}
