import org.apache.commons.lang3.ArrayUtils;

import java.util.Scanner;
import java.util.Arrays;

public class ImprovMain{
	
	static Scanner typed = new Scanner(System.in);
	
	public static void main(String[] args){
		int gameNumber =1;
		int orderDead=1;
		
		Monster.buildBattleBoard();
		
		
		char[][] tempBattleBoard = new char[10][10];//declares an array of chars
		
		
		Monster[] MonstersArray = new Monster[10];//declares an array of monsters
		
		Monster Tony= new Monster(100,12,8,"Tony");//sets array spots with new monsters
		Monster John = new Monster(100,66,7,"John");
		Monster Jack = new Monster(100,43,6,"Jack");
		Monster Cat = new Monster(100,25,5,"Cat");
		Monster Zach = new Monster(100,13,3,"Zach");
		Monster Thomas = new Monster(100,15,2,"Thomas");
		Monster David = new Monster(100, 10,9,"David");
		Monster Vincent= new Monster(100,50,5,"Vincent");
		Monster Gina= new Monster(100,45,4,"Gina");
		Monster Alex= new Monster(100,10,5,"Alex");
		
		
		//Monster.redrawBoard();
	
		while(Monster.numOfMonsters>1){
		
			MonstersArray[0]= Tony;
			MonstersArray[1]= John;
			MonstersArray[2]= Jack;
			MonstersArray[3]= Cat;
			MonstersArray[4]= Zach;
			MonstersArray[5]= Thomas;
			MonstersArray[6]= David;
			MonstersArray[7]= Vincent;
			MonstersArray[8]= Gina;
			MonstersArray[9]= Alex;
			
			
			for(Monster objMonsterAlive : MonstersArray){//goes through MonstersArray and sets the mobnsrter to obj Monster
				if(objMonsterAlive.getAlive()){//checks in that monster is allive
				objMonsterAlive.moveMonster(MonstersArray);
				}			
			}
			
			
			
			
			
			for(Monster objMonster : MonstersArray){//goes through list of monsters
			//	if(Monster.numOfMonsters>1){
					if(objMonster.getAlive()){//if moster is alive
						
						int x = objMonster.xPosition;
						int y = objMonster.yPosition;
						
			
						if(x >= 0 && x<=9 && y+1 >= 0 && y+1<=9 &&
								Monster.battleBoard[y+1][x]!= '*'){//if moster above
							
							for(Monster objFindMonster : MonstersArray){//find moster thats there
								int findX = objFindMonster.xPosition;
								int findY = objFindMonster.yPosition;
								
								if(x == findX && y+1 == findY){
									objFindMonster.setHealth(objMonster.getAttack());
									System.out.println(objFindMonster.name + " was attacked by UP " + objMonster.name);
									break;
								}
										
							}
						
						}	
							
							
					
						if(x >= 0 && x<=9 && y-1 >= 0 && y-1<=9 &&
								Monster.battleBoard[y-1][x]!= '*'){//if monster below
							
							for(Monster objFindMonster : MonstersArray){//find moster thats there
								int findX = objFindMonster.xPosition;
								int findY = objFindMonster.yPosition;
								
								if(x == findX && y-1 == findY){
									objFindMonster.setHealth(objMonster.getAttack());
									System.out.println(objFindMonster.name + " was attacked by DOWN " + objMonster.name);
									break;
								}
							}
						}
						
						
						if(x+1 >= 0 && x+1<=9 && y >= 0 && y<=9 &&
								Monster.battleBoard[y][x+1]!= '*'){//if moster to right
							
							for(Monster objFindMonster : MonstersArray){//find moster thats there
								int findX = objFindMonster.xPosition;
								int findY = objFindMonster.yPosition;
								
								if(x+1 == findX && y == findY){
									objFindMonster.setHealth(objMonster.getAttack());
									System.out.println(objFindMonster.name + " was attacked by RIGHT " + objMonster.name);
									break;
									
								}		
							}
						}
						
						if(x-1 >= 0 && x-1<=9 && y >= 0 && y<=9 &&
								Monster.battleBoard[y][x-1] != '*'){//if moster to left
							
							for(Monster objFindMonster : MonstersArray){//find moster thats there
								int findX = objFindMonster.xPosition;
								int findY = objFindMonster.yPosition;
								
								if(x-1 == findX && y == findY){
									objFindMonster.setHealth(objMonster.getAttack());
									System.out.println(objFindMonster.name + " was attacked by LEFT " + objMonster.name);
									break;
								}			
							}
						}
					
						
					}//if alive
				//	break;
			//	}//while more than 1 monster left
			}//for statement
			
			
			
			
			System.out.println("\n" + gameNumber+":");
			Monster.redrawBoard();
			gameNumber++;
			
			
			for(Monster objMonster : MonstersArray){
				if(objMonster.getHealth()<=0){
					objMonster.alive=false;
				}
				
				
				if(objMonster.getAlive()==false && objMonster.alreadyDead==false){
					
					System.out.println(objMonster.name + " is Dead!");
					objMonster.orderDead=orderDead;
					orderDead++;
					
					Monster.numOfMonsters--;
					objMonster.alreadyDead=true;
					
					
				}
			
				if(objMonster.getAlive()){	
					System.out.println(objMonster.name + " " + objMonster.getHealth());
				}

			}
			
					
			//while((typed.next()=="next")){}
			
			
		}//while loop
		
		
		
		if(Monster.numOfMonsters==0){
			
			String name1 = null;
			String name2 = null;
			
			for(Monster objMonster : MonstersArray){
				
				
				if(Monster.totalNumMonsters - objMonster.orderDead ==0){
					name1 = objMonster.name;
				}else if(Monster.totalNumMonsters - objMonster.orderDead ==1){
					name2 = objMonster.name;
				}
			}
			System.out.println("\nTIE:\n" + name1 + "\n" + name2);
			
			
			
		}else{
		
			for(Monster objMonster : MonstersArray){//gets last one alive
				if(objMonster.getAlive()){
					System.out.println("\nWINNER: " + objMonster.name);
					break;
				}
			}
		}
		
	}//main
}//class