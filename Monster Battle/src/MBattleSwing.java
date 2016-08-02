import javax.swing.*;

public class MBattleSwing extends JFrame {
	
	static Monster Tony = new Monster(100, 12, 8, "Tony");// sets array spots with new monsters
	static Monster John = new Monster(100, 66, 7, "John");
	static Monster Jack = new Monster(100, 43, 6, "Jack");
	static Monster Cat = new Monster(100, 25, 5, "Cat");
	static Monster Zach = new Monster(100, 13, 3, "Zach");
	static Monster Thomas = new Monster(100, 15, 2, "Thomas");
	static Monster David = new Monster(100, 10, 9, "David");
	static Monster Vincent = new Monster(100, 50, 5, "Vincent");
	static Monster Gina = new Monster(100, 45, 4, "Gina");
	static Monster Alex = new Monster(100, 10, 5, "Alex");
	

	public static void main(String[] args) {

		new Window();
		

	}// main
		
}// class