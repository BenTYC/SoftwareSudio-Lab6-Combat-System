package character;

public class Skill {
	
	private String message;
	private int damage;	
	
	public Skill(){	}
	public Skill(String message, int damage){
		this.message = message;
		this.damage = damage;
	}
		
	public void setMessage(String message) {this.message = message;}		
	public String getMessage() {return this.message;}
	public void setDamage(int damage) {this.damage = damage;}	
	public int getDamage() {return this.damage;}
}
