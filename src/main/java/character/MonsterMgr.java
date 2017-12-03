package character;

import java.util.ArrayList;
import java.util.List;
import com.alibaba.fastjson.JSON;

public class MonsterMgr extends FightCreatureMgr{
	
	private List<Monster> monsterList;
	
	public MonsterMgr() {
		this.monsterList = new ArrayList<Monster>();
	}
	
	public MonsterMgr(String data) {
		// TODO: parse data and generate list of players
		this.monsterList = JSON.parseArray(data, Monster.class);
		this.setNumberOfSurvivors(this.monsterList.size());
	}
	
	public void printStatuses(){
		System.out.println("Monster陣營狀態：");
		for(Monster monster: monsterList)
			monster.printStatus();
	}
	
	public List<Monster> getMonsters(){
		return monsterList;
	}
	
	/*	
	public void addMonster(Monster monster){
		MonsterMgr.monsterAssociation.add(monster);
	}
	
	public void callMonsters(int number) throws RuntimeException {
		if( number < 1 ){
			System.out.println("呼叫人數需至少一人");	
			throw new RuntimeException();
		}else if( number > monsterAssociation.size() ){
			System.out.println("Erroe: monsters人數上限： " + monsterAssociation.size());	
			throw new RuntimeException();
		}
		
		//亂數產生index of monsterAssociation
		int[] indexOfMonstersToCall = new int[number];
		indexOfMonstersToCall = NumberGenerator.generateNumbers(0, monsterAssociation.size() - 1, number);
		
		for(int i = 0; i < number; i++)
			this.monsterList.add(monsterAssociation.get(indexOfMonstersToCall[i]));
		
		this.setNumberOfSurvivors(number);
	}

	
	private static List<Monster> monsterAssociation = new ArrayList<Monster>() {
	    
		private static final long serialVersionUID = 1L;

		{
	        add(new Monster("格鬥家", "餓狼", 90, 60, "我流拳法", 150, "受到", "點傷害", "餓狼失去戰鬥能力"));
	        add(new Monster("外星人", "波羅斯", 90, 60, "崩星咆哮砲", 150, "受到", "點傷害", "波羅斯失去戰鬥能力"));
	        add(new Monster("忍者", "索尼克", 40, 80, "十影葬", 100, "受到", "點傷害", "索尼克失去戰鬥能力"));
	        add(new Monster("怪人", "深海王", 90, 40, "溶解唾液", 120, "受到", "點傷害", "深海王失去戰鬥能力"));
	        add(new Monster("怪人", "鳳凰男", 50, 20, "鳥喙攻擊", 50, "受到", "點傷害", "鳳凰男失去戰鬥能力"));
	        add(new Monster("怪人", "獸王", 80, 20, "獅子斬", 50, "受到", "點傷害", "獸王失去戰鬥能力"));
	        add(new Monster("怪人", "機神", 50, 20, "巨劍", 50, "受到", "點傷害", "機神失去戰鬥能力"));
	        add(new Monster("怪人", "切割王", 50, 20, "酷刑", 50, "受到", "點傷害", "切割王失去戰鬥能力"));
	        add(new Monster("怪人", "馬歇爾大猩猩", 50, 20, "軍刀攻擊", 50, "受到", "點傷害", "馬歇爾大猩猩失去戰鬥能力"));
	        add(new Monster("怪人", "弩S", 50, 20, "愛心重擊", 50, "受到", "點傷害", "弩S失去戰鬥能力"));
	        add(new Monster("怪人", "女神眼鏡", 50, 20, "洗腦愛心光線", 50, "受到", "點傷害", "女神眼鏡失去戰鬥能力"));
	    }
	};
	*/	
	
}
