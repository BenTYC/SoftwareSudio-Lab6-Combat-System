package character;

public class Damaged {
	
	private String prefix;
	private String suffix;
	
	public Damaged(){	}
	public Damaged(String prefix, String suffix){
		this.prefix = prefix;
		this.suffix = suffix;
	}
	public void setPrefix(String prefix) {this.prefix = prefix;}		
	public String getPrefix() {return this.prefix;}
	public void setSuffix(String suffix) {this.suffix = suffix;}		
	public String getSuffix() {return this.suffix;}	
}
