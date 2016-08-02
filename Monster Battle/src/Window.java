import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;



public class Window extends JFrame{
	
	public static JButton newGame, next;
	public static JRadioButton stopEveryTime, stopDeath, noStop;
	public static JTextArea textBox;
	public static JLabel monster1, monster2, monster3, monster4, monster5;
	public static JLabel monster6, monster7, monster8, monster9, monster10; 
	public static JPanel thePanel;
	
	
	
	public Window() {

		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setTitle("Monster Battle");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		thePanel = new JPanel();
		ButtonListener lButton = new ButtonListener();

		newGame = new JButton("Start Game");
		newGame.addActionListener(lButton);
		thePanel.add(newGame);

		next = new JButton("Next Round");
		next.addActionListener(lButton);
		thePanel.add(next);

		textBox = new JTextArea(10, 10);
		thePanel.add(textBox);

		noStop = new JRadioButton("No Stops");
		stopEveryTime = new JRadioButton("Stop Every Round");
		stopDeath = new JRadioButton("Stop at Death");

		ButtonGroup stops = new ButtonGroup();// Makes only one button clicked
		stops.add(noStop);
		stops.add(stopEveryTime);
		stops.add(stopDeath);

		JPanel radioButtons = new JPanel();
		Border rBorder = BorderFactory.createTitledBorder("Set Stops:");
		radioButtons.setBorder(rBorder);

		radioButtons.add(noStop);
		radioButtons.add(stopEveryTime);
		radioButtons.add(stopDeath);
		
		noStop.setSelected(true);

		thePanel.add(radioButtons);
		
		monster1 = new JLabel("1");
		monster2 = new JLabel("2");
		monster3 = new JLabel("3");
		monster4 = new JLabel("4");
		monster5 = new JLabel("5");
		monster6 = new JLabel("6");
		monster7 = new JLabel("7");
		monster8 = new JLabel("8");
		monster9 = new JLabel("9");
		monster10 = new JLabel("10");

		thePanel.add(monster1);
		thePanel.add(monster2);
		thePanel.add(monster3);
		thePanel.add(monster4);
		thePanel.add(monster5);
		thePanel.add(monster6);
		thePanel.add(monster7);
		thePanel.add(monster8);
		thePanel.add(monster9);
		thePanel.add(monster10);
		
		this.add(thePanel);
		this.setVisible(true);
	}

}
