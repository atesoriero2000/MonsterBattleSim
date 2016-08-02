import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {


	String name1, name2;
	
	boolean deathStop = false;
	static int gameNumber = 1;
	static public int orderDead = 1;
	boolean waitForNext = false;

	char[][] tempBattleBoard = new char[10][10];// declares an array of chars

	Monster[] MonstersArray = new Monster[10];// declares an array of monsters


		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == Window.newGame) {
				
				MonstersArray[0] = MBattleSwing.Tony;
				MonstersArray[1] = MBattleSwing.John;
				MonstersArray[2] = MBattleSwing.Jack;
				MonstersArray[3] = MBattleSwing.Cat;
				MonstersArray[4] = MBattleSwing.Zach;
				MonstersArray[5] = MBattleSwing.Thomas;
				MonstersArray[6] = MBattleSwing.David;
				MonstersArray[7] = MBattleSwing.Vincent;
				MonstersArray[8] = MBattleSwing.Gina;
				MonstersArray[9] = MBattleSwing.Alex;
				
				Monster.buildBattleBoard();
				
				for (Monster aMonster : MonstersArray) {

					aMonster.resetMonsters(MonstersArray);
				}
				
				Window.textBox.setText("");
				
				while (Monster.numOfMonsters > 1) {
					if(!waitForNext){
					
					MonstersArray[0] = MBattleSwing.Tony;
					MonstersArray[1] = MBattleSwing.John;
					MonstersArray[2] = MBattleSwing.Jack;
					MonstersArray[3] = MBattleSwing.Cat;
					MonstersArray[4] = MBattleSwing.Zach;
					MonstersArray[5] = MBattleSwing.Thomas;
					MonstersArray[6] = MBattleSwing.David;
					MonstersArray[7] = MBattleSwing.Vincent;
					MonstersArray[8] = MBattleSwing.Gina;
					MonstersArray[9] = MBattleSwing.Alex;

					for (Monster objMonsterAlive : MonstersArray) {// goes
																	// through
																	// MonstersArray
																	// and sets
																	// the
																	// mobnsrter
																	// to obj
																	// Monster
						if (objMonsterAlive.getAlive()) {// checks in that
															// monster is allive
							objMonsterAlive.moveMonster(MonstersArray);
						}
					}

					for (Monster objMonster : MonstersArray) {// goes through
																// list of
																// monsters
						if (objMonster.getAlive()) {// if moster is alive

							int x = objMonster.xPosition;
							int y = objMonster.yPosition;

							if (x >= 0 && x <= 9 && y + 1 >= 0 && y + 1 <= 9
									&& Monster.battleBoard[y + 1][x] != '*') {// if
																				// moster
																				// above

								for (Monster objFindMonster : MonstersArray) {// find
																				// moster
																				// thats
																				// there
									int findX = objFindMonster.xPosition;
									int findY = objFindMonster.yPosition;

									if (x == findX && y + 1 == findY) {
										objFindMonster.setHealth(objMonster
												.getAttack());
										System.out.println(objFindMonster.name
												+ " was attacked by UP "
												+ objMonster.name);
										break;
									}

								}

							}

							if (x >= 0 && x <= 9 && y - 1 >= 0 && y - 1 <= 9
									&& Monster.battleBoard[y - 1][x] != '*') {// if
																				// monster
																				// below

								for (Monster objFindMonster : MonstersArray) {// find
																				// moster
																				// thats
																				// there
									int findX = objFindMonster.xPosition;
									int findY = objFindMonster.yPosition;

									if (x == findX && y - 1 == findY) {
										objFindMonster.setHealth(objMonster
												.getAttack());
										System.out.println(objFindMonster.name
												+ " was attacked by DOWN "
												+ objMonster.name);
										break;
									}
								}
							}

							if (x + 1 >= 0 && x + 1 <= 9 && y >= 0 && y <= 9
									&& Monster.battleBoard[y][x + 1] != '*') {// if
																				// moster
																				// to
																				// right

								for (Monster objFindMonster : MonstersArray) {// find
																				// moster
																				// thats
																				// there
									int findX = objFindMonster.xPosition;
									int findY = objFindMonster.yPosition;

									if (x + 1 == findX && y == findY) {
										objFindMonster.setHealth(objMonster
												.getAttack());
										System.out.println(objFindMonster.name
												+ " was attacked by RIGHT "
												+ objMonster.name);
										break;

									}
								}
							}

							if (x - 1 >= 0 && x - 1 <= 9 && y >= 0 && y <= 9
									&& Monster.battleBoard[y][x - 1] != '*') {// if
																				// moster
																				// to
																				// left

								for (Monster objFindMonster : MonstersArray) {// find
																				// moster
																				// thats
																				// there
									int findX = objFindMonster.xPosition;
									int findY = objFindMonster.yPosition;

									if (x - 1 == findX && y == findY) {
										objFindMonster.setHealth(objMonster
												.getAttack());
										System.out.println(objFindMonster.name
												+ " was attacked by LEFT "
												+ objMonster.name);
										break;
									}
								}
							}

						}// if alive
					}// for statement
					

					System.out.println("\n" + gameNumber + ":");
					Monster.redrawBoard();
					gameNumber++;

					for (Monster objMonster : MonstersArray) {
						if (objMonster.getHealth() <= 0) {
							objMonster.alive = false;
						}

						if (objMonster.getAlive() == false
								&& objMonster.alreadyDead == false) {

							System.out.println(objMonster.name + " is Dead!");
							objMonster.orderDead = orderDead;
							orderDead++;

							Monster.numOfMonsters--;
							objMonster.alreadyDead = true;
							deathStop = true;

						}

						if (objMonster.getAlive()) {
							System.out.println(objMonster.name + " "
									+ objMonster.getHealth());
						}

					}
/*
					if (Window.stopEveryTime.isSelected() || (Window.stopDeath.isSelected() && deathStop)) {
						waitForNext = true;
						
					}*/
					
				}else{
					if(e.getSource() == Window.next){
						waitForNext = false;
						deathStop = false;
					}
				}

				}// while loop
					
					
					
					
					
					
					
					
					
					
					
					

				if (Monster.numOfMonsters == 0) {

					for (Monster objMonster : MonstersArray) {

						if (Monster.totalNumMonsters - objMonster.orderDead == 0) {
							name1 = objMonster.name;
						
						} else if (Monster.totalNumMonsters
								- objMonster.orderDead == 1) {
							name2 = objMonster.name;
						}
					}
					System.out.println("\nTIE:\n" + name1 + "\n" + name2);

				} else {

					for (Monster objMonster : MonstersArray) {// gets last one
																// alive
						if (objMonster.getAlive()) {
							System.out.println("\nWINNER: " + objMonster.name);
							break;
						}
					}
				}
				
			}
		}
	}