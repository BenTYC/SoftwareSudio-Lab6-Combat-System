package character;

import java.util.ArrayList;
import java.util.List;
import com.alibaba.fastjson.JSON;

public class HeroMgr extends FightCreatureMgr{
	
	private List<Hero> heroList;
	//private List<Hero> heroAssociation;
	
	public HeroMgr() {
		this.heroList = new ArrayList<Hero>();
		//this.heroAssociation = new ArrayList<Hero>();
	}
	
	public HeroMgr(String data) {
		// TODO: parse data and generate list of players
		this.heroList = JSON.parseArray(data, Hero.class);
		this.setNumberOfSurvivors(this.heroList.size());
	}
	
	public void printStatuses(){
		System.out.println("Hero陣營狀態：");
		for(Hero hero: heroList)
			hero.printStatus();
	}
	
	public List<Hero> getHeros(){
		return this.heroList;
	}
	
	public void addHero(Hero hero){
		HeroMgr.heroAssociation.add(hero);
	}
	
	public void callHeros(int number) throws RuntimeException {
		if( number < 1 ){
			System.out.println("呼叫人數需至少一人");	
			throw new RuntimeException();
		}else if( number > heroAssociation.size() ){
			System.out.println("Erroe: Heros人數上限： " + heroAssociation.size());	
			throw new RuntimeException();
		}
		
		//亂數產生index of heroAssociation
		int[] herosCalled = new int[number];
		herosCalled = NumberGenerator.generateNumbers(0, heroAssociation.size() - 1, number);
		
		for(int i = 0; i < number; i++)
			this.heroList.add(heroAssociation.get(herosCalled[i]));
		
		this.setNumberOfSurvivors(number);
	}

	
	private static List<Hero> heroAssociation = new ArrayList<Hero>() {
	    
		private static final long serialVersionUID = 1L;

		{
	        add(new Hero("一拳超人", "琦玉", Integer.MAX_VALUE, Integer.MAX_VALUE,
	    			"連續普通拳", Integer.MAX_VALUE, "受到", "點傷害，不算什麼", "我是興趣使然的英雄"));
	        add(new Hero("改造人", "傑諾斯", 90, 30, "燒燬砲", 120, "受到", "點傷害，...", "退下了"));
	        add(new Hero("普通人", "無照騎士", 40, 50, "正義撞擊", 30, "受到", "點傷害", "退下了"));
	        add(new Hero("超能力者", "吹雪", 50, 20, "念打", 70, "受到", "點傷害", "退下了"));
	        add(new Hero("超能力者", "龍卷", 50, 80, "念流迴轉嵐", 100, "受到", "點傷害", "退下了"));
	        add(new Hero("武士", "原子武士", 90, 40, "原子斬", 100, "受到", "點傷害", "退下了"));
	        add(new Hero("格鬥家", "邦格", 90, 50, "流水陣", 90, "受到", "點傷害", "退下了"));
	        add(new Hero("天才兒童", "童帝", 40, 40, "足球運球踢", 90, "受到", "點傷害", "退下了"));
	        add(new Hero("肌肉男", "超合金黑光", 100, 40, "超合金火箭砲", 90, "受到", "點傷害", "退下了"));
	        add(new Hero("不良少年", "金屬球棒", 80, 40, "怒羅嚴暴擊", 90, "受到", "點傷害", "退下了"));
	    }
	};
	
	/* (本來放在app的code)
	heroMgr.addHero(new Hero("改造人", "傑諾斯", 90, 30, "燒燬砲", 120, "受到", "點傷害，...", "傑諾斯退下了"));
	heroMgr.addHero(new Hero("普通人", "無照騎士", 40, 5, "正義撞擊", 30, "受到", "點傷害", "無照騎士退下了"));
	heroMgr.addHero(new Hero("超能力者", "吹雪", 50, 25, "念打", 70, "受到", "點傷害", "吹雪退下了"));
	heroMgr.addHero(new Hero("超能力者", "龍卷", 50, 80, "念流迴轉嵐", 100, "受到", "點傷害", "龍卷退下了"));
	heroMgr.addHero(new Hero("武士", "原子武士", 90, 40, "原子斬", 100, "受到", "點傷害", "原子武士退下了"));
	heroMgr.addHero(new Hero("格鬥家", "邦格", 90, 50, "流水陣", 90, "受到", "點傷害", "邦格退下了"));
	heroMgr.addHero(new Hero("天才兒童", "童帝", 40, 40, "足球運球踢", 90, "受到", "點傷害", "童帝退下了"));
	heroMgr.addHero(new Hero("肌肉男", "超合金黑光", 100, 45, "超合金火箭砲", 90, "受到", "點傷害", "超合金黑光退下了"));
	heroMgr.addHero(new Hero("不良少年", "金屬球棒", 80, 40, "怒羅嚴暴擊", 90, "受到", "點傷害", "金屬球棒退下了"));
	heroMgr.addHero(new Hero("一拳超人", "琦玉", Integer.MAX_VALUE, Integer.MAX_VALUE,
			"連續普通拳", Integer.MAX_VALUE, "受到", "點傷害，不算什麼", "我是興趣使然的英雄"));
	*/
	
}
