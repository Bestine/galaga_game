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
	
	JLabel enemy1Label;
	JLabel enemy2Label;
	JLabel enemy3Label;
	
	RoundedPanel bulletRoundPanel;
	
	//Define the actionsmap
	LeftAction leftAction;
	RightAction rightAction;
	UpAction upAction;
	
	Frame(){
		ImageIcon fighterIcon = new ImageIcon("images/fighter.png");
		ImageIcon enemy1Icon = new ImageIcon("images/enemy1.png");
		ImageIcon enemy2Icon = new ImageIcon("images/enemy2.jpeg");
		ImageIcon enemy3Icon = new ImageIcon("images/enemy3.png");
		
		//fighter description
		fighterLabel = new JLabel();
		fighterLabel.setIcon(fighterIcon);
		fighterLabel.setBounds(350, 420, 300, 170);
		
		//ENEMIES
		//enemy 1
		enemy1Label = new JLabel();
		enemy1Label.setIcon(enemy1Icon);
		enemy1Label.setBounds(350, 5, 150, 85);
		//enemy 2
		enemy2Label = new JLabel();
		enemy2Label.setIcon(enemy2Icon);
		enemy2Label.setBounds(350, -90, 150, 85);
		//enemy 3
		enemy3Label = new JLabel();
		enemy3Label.setIcon(enemy3Icon);
		enemy3Label.setBounds(350, -180, 150, 85);
		
		//BULLETS
		bulletRoundPanel = new RoundedPanel(null, 15, Color.RED);
		bulletRoundPanel.setBounds(465, 400, 20, 20);
		bulletRoundPanel.setOpaque(false);
		
		
		// Creating key bindings for moving the shooter/fighter
		upAction = new UpAction();
		leftAction = new LeftAction();
		rightAction = new RightAction();
		
		fighterLabel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
		fighterLabel.getActionMap().put("leftAction", leftAction);
		fighterLabel.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
		fighterLabel.getActionMap().put("rightAction", rightAction);
		
		bulletRoundPanel.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upAction");
		bulletRoundPanel.getActionMap().put("upAction", upAction);
		
		this.add(fighterLabel);
		this.add(enemy1Label);
		this.add(enemy2Label);
		this.add(enemy3Label);
		this.add(bulletRoundPanel);
		
		this.setTitle("Galaga Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.setSize(900, 600);
		this.setVisible(true);
		this.getContentPane().setBackground(Color.BLACK);
		
		moveEnemies();
	}
	
	//This function constantly moves the enemies downwards
	public void moveEnemies() {
		while(true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			enemy1Label.setLocation(enemy1Label.getX(), enemy1Label.getY()+10);
			enemy2Label.setLocation(enemy2Label.getX(), enemy2Label.getY()+10);
			enemy3Label.setLocation(enemy3Label.getX(), enemy3Label.getY()+10);
		}
	}
	
//	public void moveBullets() {
//		while(true) {
//			try {
//				Thread.sleep(200);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		bulletRoundPanel.setLocation(bulletRoundPanel.getX(),
//				bulletRoundPanel.getY()-10);
//			
//		}
//	}

	// LEFT and RIGHT Action classes move the players 
	public class LeftAction extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			fighterLabel.setLocation(fighterLabel.getX()-10, 
					fighterLabel.getY());
			
		}
		
	}

	public class RightAction extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			fighterLabel.setLocation(fighterLabel.getX()+10, 
					fighterLabel.getY());
		}
		
	}
	public class UpAction extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			bulletRoundPanel.setLocation(bulletRoundPanel.getX(), 
					bulletRoundPanel.getY()-10);
			
		}
	}

}