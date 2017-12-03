package character;

import java.util.ArrayList;
import java.util.List;
import com.alibaba.fastjson.annotation.JSONField;

public abstract class FightCreature implements Creature{
	private String type;
	private String name;
	private int hp;
	private int armor;	
	private List<Skill> skills = new ArrayList<Skill>();
	private List<Damaged> damaged = new ArrayList<Damaged>();
	@JSONField(name="last-words")
	private String lastWords;
	
	public void setType(String type) { this.type = type; }		
	public String getType() { return this.type; }
	public void setName(String name) { this.name = name; }		
	public String getName() { return this.name; }
	public void setHp(int hp) { this.hp = hp; }		
	public int getHp() { return this.hp; }	
	public void setArmor(int armor) { this.armor = armor; }		
	public int getArmor() { return this.armor; }	
	public void setLastWords(String lastWords) { this.lastWords = lastWords; }		
	public String getLastWords() { return this.lastWords; }	
	public List<Skill> getSkills() { return this.skills; }
	public void setSkills(List<Skill> skills) {	this.skills = skills; }
	public void addSkill(Skill skill) {	this.skills.add(skill); }
	public List<Damaged> getDamaged() { return this.damaged; }
	public void setDamaged(List<Damaged> damaged) {	this.damaged = damaged;	}	
	public void addDamaged(Damaged damaged) { this.damaged.add(damaged); }

	public void printStatus(){
		//show the statuses of the creatures, such as HP and name
		if( this.hp > 0)
			System.out.println("◎" + " 「 " + this.type + " 」 " + this.name + "  hp: " + this.hp);
		else
			System.out.println("◎" + " 「 " + this.type + " 」 " + this.name + " 失去戰鬥能力 ");
	}	
	
	@Override
	public void attack(Creature creature) {
		// TODO Auto-generated method stub
		
		//隨機產生skill的index (選擇某樣攻擊)
		int skillIndex = NumberGenerator.generateNumber(0, this.skills.size() - 1, 1);
		
		//攻擊宣言
		System.out.println( "●" + this.name + "使用了" + this.skills.get(skillIndex).getMessage() );
		
		//對方承受攻擊
		creature.takeDamage(this.skills.get(skillIndex).getDamage());
	}

	public void takeDamage(int damage) {
		// TODO Auto-generated method stub
		if( damage <= 0 || (damage - this.armor) <= 0 ){ //無傷狀況
			System.out.println("●" + " 「 " + this.type + " 」 " + this.name + "毫髮無傷");	
		}else{ //傷害處理
			int hurt = damage - armor;
			this.hp -= hurt;
			this.damageMsg(hurt);
			if( this.hp <= 0 ){
				this.hp = 0;
				System.out.println("§" + " 「 " + this.type + " 」 " + this.name + this.getLastWords());
			}
		}
	}
	
	private void damageMsg(int hurt) {
		//隨機產生getDamaged的index
		int getDamagedIndex = NumberGenerator.generateNumber(0, this.damaged.size() - 1, 1);
		
		//產生damage massage
		System.out.println("●" + " 「 " + this.type + " 」 " + this.name 
				+ this.damaged.get(getDamagedIndex).getPrefix()
				+ hurt + this.damaged.get(getDamagedIndex).getSuffix() );
	}
}
