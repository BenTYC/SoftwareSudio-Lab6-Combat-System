package character;


public class Hero extends FightCreature {
	
	public Hero(String type, String name, int hp, int armor, String skillMessage, 
			int skillDamage, String damagedPreffix, String damagedSuffix, String lastWords){
		this.setType(type);
		this.setName(name);
		this.setHp(hp);
		this.setArmor(armor);
		this.addSkill(new Skill(skillMessage, skillDamage));
		this.addDamaged(new Damaged(damagedPreffix, damagedSuffix));
		this.setLastWords(lastWords);		
	}
}
