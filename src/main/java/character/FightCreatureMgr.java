package character;

public class FightCreatureMgr {
	
	private int numberOfSurvivors;
	
	public int getNumberOfSurvivors(){
		return this.numberOfSurvivors;
	}
	
	public void setNumberOfSurvivors(int number){
		this.numberOfSurvivors = number;
	}
	
	/*
	protected List<FightCreature> survivorsList;
	public void printStatuses(){
		for(FightCreature survivor: survivorsList)
			survivor.printStatus();
	}*/
}
