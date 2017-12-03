package netdb.courses.softwarestudio.lab.rpg.combat_system;
import character.HeroMgr;
import character.MonsterMgr;
import netdb.courses.softwarestudio.lab.http.HttpRetriever;

public class App {
	
	private static final String SERVER_ADDR = "https://sslab5.herokuapp.com/";

	public static void main(String[] args) throws InterruptedException {
		
		String jsonString = HttpRetriever.retrieveContent(SERVER_ADDR);
		//System.out.println(jsonString);		
		
		// TODO: Create a hero group and a monster group
		HeroMgr heroMgr = new HeroMgr();
		MonsterMgr monsterMgr = new MonsterMgr (jsonString);
		//MonsterMgr monsterMgr = new MonsterMgr ();
		
		// TODO: Add creatures to each group
		int heroNeed = 3;
		heroMgr.callHeros(heroNeed);
		//int monsterNeed = 5;
		//monsterMgr.callMonsters(monsterNeed);
		
		int round = 1;
		while (true) {
			System.out.println("\n第 " + round++ + " 回合");
			// TODO: show the statuses of the creatures, such as HP and name
			heroMgr.printStatuses();
			monsterMgr.printStatuses();
			Thread.sleep(1500);
			
			// TODO heroes and monsters group attack each other
			//每次各陣營推出一人戰鬥(list中的最後一人)
			
			//hero先攻
			heroMgr.getHeros().get(heroMgr.getNumberOfSurvivors()-1).attack(monsterMgr.getMonsters().get(monsterMgr.getNumberOfSurvivors()-1));
			Thread.sleep(1500);
			
			//檢查被攻擊的monster是否死亡：是→下一輪，否：換他攻擊
			if( monsterMgr.getMonsters().get(monsterMgr.getNumberOfSurvivors()-1).getHp() == 0 ) {
				monsterMgr.setNumberOfSurvivors(monsterMgr.getNumberOfSurvivors()-1);
				//檢查monster是否死光：是→結束戰鬥
				if(monsterMgr.getNumberOfSurvivors() == 0)
					break;
				else
					continue;
			}
			
			//換monster攻擊
			monsterMgr.getMonsters().get(monsterMgr.getNumberOfSurvivors()-1).attack(heroMgr.getHeros().get(heroMgr.getNumberOfSurvivors()-1));
			Thread.sleep(1500);
			
			//檢查被攻擊的hero是否死亡
			if( heroMgr.getHeros().get(heroMgr.getNumberOfSurvivors()-1).getHp() == 0 ) {
				heroMgr.setNumberOfSurvivors(heroMgr.getNumberOfSurvivors()-1);
				//檢查hero是否死光：是→結束戰鬥
				if(heroMgr.getNumberOfSurvivors() == 0)
					break;
				else
					continue;				
			}
			
			// use this line of code to pause the program for 1.5 seconds
			// (1500 ms)
			// you can add this code after each creature attack
			//Thread.sleep(1500);
		}

		// TODO: print the combat result
		if(monsterMgr.getNumberOfSurvivors() == 0 && heroMgr.getNumberOfSurvivors() == 0){
			System.out.println("It's a tie");
		}else if(monsterMgr.getNumberOfSurvivors() == 0){
			System.out.println("Heros win");
		}else{
			System.out.println("Monsters win");
		}

	}
}
