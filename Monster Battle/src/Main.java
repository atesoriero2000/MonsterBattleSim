import org.apache.commons.lang3.ArrayUtils;
import java.util.Arrays;

public class Main{
	public static void main(String[] args){
		Monster.buildBattleBoard();
		
		
		char[][] tempBattleBoard = new char[10][10];//declares an array of chars
		
		
		Monster[] MonstersArray = new Monster[4];//declares an array of monsters
		
		MonstersArray[0]= new Monster(500,20,8,"Tony");//sets array spots with new monsters
		MonstersArray[1]= new Monster(500,20,7,"John");
		MonstersArray[2]= new Monster(500,20,6,"Jack");
		MonstersArray[3]= new Monster(500,20,5,"Cat");
		
		Monster.redrawBoard();
		/*
		Monster Tony= new Monster(500,20,100,"Tony");
		Monster John= new Monster(500,20,100,"John");
		Monster Jack= new Monster(500,20,100,"Jack");
		Monster Cat= new Monster(500,20,100,"Cat");
		*/
		
		for(Monster objMonster : MonstersArray){//goes through MonstersArray and sets the mobnsrter to obj Monster
		
			if(objMonster.getAlive()){//checks in that monster is allive
			
		//	int arrayItemIndex = ArrayUtils.indexOf(MonstersArray, objMonster);
			objMonster.moveMonster(MonstersArray);//, arrayItemIndex);
			
			}			
		}
		Monster.redrawBoard();
	}
}