package galaga_game;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;

public class Frame extends JFrame{
	
	JLabel fighterLabel;
	
	//Define the actionsmap
	LeftAction leftAction;
	RightAction rightAction;
	
	Frame(){
		ImageIcon fighterIcon = new ImageIcon("images/fighter.png");
		
		fighterLabel = new JLabel();
		fighterLabel.setIcon(fighterIcon);
		fighterLabel.setBounds(350, 420, 300, 170);
		
		// Creating key bindings for moving the shooter/fighter
		leftAction = new LeftAction();
		rightAction = new RightAction();
		
		fighterLabel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
		fighterLabel.getActionMap().put("leftAction", leftAction);
		fighterLabel.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
		fighterLabel.getActionMap().put("rightAction", rightAction);
		
		this.add(fighterLabel);
		
		this.setTitle("Galaga Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.setSize(900, 600);
		this.setVisible(true);
		this.getContentPane().setBackground(Color.BLACK);
	}

	public class LeftAction extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			fighterLabel.setLocation(fighterLabel.getX()-10, fighterLabel.getY());
			
		}
		
	}

	public class RightAction extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			fighterLabel.setLocation(fighterLabel.getX()+10, fighterLabel.getY());
		}
		
	}

}