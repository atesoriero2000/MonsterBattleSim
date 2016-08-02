import java.util.Arrays;

 
public class Monster{
	static char[][] battleBoard = {
		{'*','*','*','*','*','*','*','*','*','*',},
		{'*','*','*','*','*','*','*','*','*','*',},
		{'*','*','*','*','*','*','*','*','*','*',},
		{'*','*','*','*','*','*','*','*','*','*',},
		{'*','*','*','*','*','*','*','*','*','*',},
		{'*','*','*','*','*','*','*','*','*','*',},
		{'*','*','*','*','*','*','*','*','*','*',},
		{'*','*','*','*','*','*','*','*','*','*',},
		{'*','*','*','*','*','*','*','*','*','*',},
		{'*','*','*','*','*','*','*','*','*','*',}
	};
	private int health;
	private int attack;
	private int movement;
	
	public boolean alive = true;
	
	public int orderDead;
	public String name = "Big Monster";
	public char nameChar1 = 'B';
	public int xPosition = 0;
	public int yPosition = 0;
	public static int numOfMonsters = 0;
	public static int totalNumMonsters = 0;
	public boolean alreadyDead = false;
	
	 public static int maxXBoardSpace = 9; // battleBoard.length - 1;//cause start of array is 0 0 not 1 1
	 public static int maxYBoardSpace = 9; // battleBoard[0].length - 1;
	
	
	
	//CONSTRUCTOR
	public Monster(int health, int attack, int movement, String name){
	
		this.health=health;
		this.attack=attack;
		this.movement=movement;
		this.name=name;
		
		
		 int maxXBoardSpace = 9; // battleBoard.length - 1;//cause start of array is 0 0 not 1 1
		 int maxYBoardSpace = 9; // battleBoard[0].length - 1;
		 
		 int randNumX, randNumY;
		 	   
	
		 
		 do {//finds random spot or monster
		
			
			 randNumX = (int) (Math.random() * maxXBoardSpace);
			 randNumY = (int) (Math.random() * maxYBoardSpace);
			
			 
		 }while(battleBoard[randNumX][randNumY] != '*');//makes sure spot is empty
		 	 
		 
		 
		this.xPosition = randNumX;
		this.yPosition = randNumY;
			         
		 this.nameChar1 = this.name.charAt(0);//gets firs char of monster name and stes it to random spot
		
		 battleBoard[this.yPosition][this.xPosition] = this.nameChar1;
		 	         
		 numOfMonsters++;
		 totalNumMonsters++;
		 
		 	         
	}
		

	public void resetMonsters(Monster[] monster){
		
		this.health=100;
		this.alive = true;
		this.alreadyDead = false;
		
		int randNumX, randNumY; 	   
	
		 
		 do {//finds random spot or monster
		
			
			 randNumX = (int) (Math.random() * maxXBoardSpace);
			 randNumY = (int) (Math.random() * maxYBoardSpace);
			
			 
		 }while(battleBoard[randNumX][randNumY] != '*');//makes sure spot is empty
		 	 
		 
		 
		this.xPosition = randNumX;
		this.yPosition = randNumY;
		
		battleBoard[this.yPosition][this.xPosition] = this.nameChar1;
		
		numOfMonsters = totalNumMonsters;
		ButtonListener.orderDead = 1;
		ButtonListener.gameNumber = 1;
		
		
	}
	
	
	
	public static void buildBattleBoard(){
		
		for( char[] row : battleBoard){
			Arrays.fill(row, '*');
			
		}
	}
	
	
	public static void redrawBoard(){
		
		
		Window.textBox.setText("");
		
		for(int k = 1; k<= 30; k++){
			Window.textBox.append("-");

			
		}
		Window.textBox.append("\n");
		
		
		for(int rows=0; rows <= Monster.maxXBoardSpace; rows++){
			for(int colums=0; colums <= Monster.maxYBoardSpace; colums++){

				Window.textBox.append("|"+ battleBoard[rows][colums]+"|");
			}
			
			Window.textBox.append("\n");
		}
		

		for(int k = 1; k<= 30; k++){
			Window.textBox.append("-");

			
		}
	}
	
	
	
	
	public void moveMonster(Monster[] monster){//, int arrayItemIndex)
	
		boolean isSpaceOpen = true;
		
		int maxXBoardSpace = battleBoard.length - 1;//ROWS //cause start of array is 0 0 not 1 1
		int maxYBoardSpace = battleBoard[0].length - 1;//COLUMNS
		
		
		while(isSpaceOpen){//==true
			
			int randomDirection = (int)(Math.random()*4);
			int randomDistance = (int)(Math.random()*(this.getMovement()));
			
			battleBoard[this.yPosition][this.xPosition] = '*'; //turns current spot back to *
			
			//System.out.println(randomDistance + " " + randomDirection);
			
			
		//CHECK IF GOING OFF BOARD
			if(randomDirection == 0){//NORTH
				
				if(this.yPosition - randomDistance <0){//if moster is going up of the board
					this.yPosition = 0;
				
				}else{
					this.yPosition -= randomDistance;
				}
				
				
				
			}else if(randomDirection == 1){//EAST
				
				if(this.xPosition + randomDistance > maxXBoardSpace){//if moving too far left
					this.xPosition = maxXBoardSpace;
				
				}else{
					this.xPosition+= randomDistance;
				}
				
				
				
			}else if(randomDirection == 2){//SOUTH
				
				if(this.yPosition + randomDistance > maxYBoardSpace){
					this.yPosition = maxYBoardSpace;  
				
				}else{
					this.yPosition += randomDistance;
				}
				
				
				
			}else if(randomDirection == 3){//WEST
				
				if(this.xPosition - randomDistance < 0){
					this.xPosition = 0;
				}else{
					this.xPosition -= randomDistance;
				}
			}// end of array limit check
			
			
			if(battleBoard[this.yPosition][this.xPosition]=='*'){//if found open space exit function
				isSpaceOpen=false;
			}
			
		}//isSpaceOpen loop
		
		
		battleBoard[this.yPosition][this.xPosition] = this.nameChar1;
		System.out.println("\n" + this.name);
		System.out.println("X: " + (this.xPosition+1));
		System.out.println("Y: " + (this.yPosition+1));
		
	}// method end
	
	
	public void setHealth(int health){
		this.health -= health;

	}
	
	
	
	//ACSESSORS
	public int getAttack(){
			return attack;
		}
		     
	public int getMovement(){
		    return movement;
	     }
	 	  
	public int getHealth(){
	         return health;
	 	    }
	      
	public boolean getAlive(){
	 	        return alive;
		    }
	
	

	
}