package character;

public class NumberGenerator {
	
	public static int[] generateNumbers(int from, int to, int count){

		int range = to - from;
		int[] generatedNumbers = new int[count];
				
		for(int i = 0; i < count; i++){
			generatedNumbers[i] = (int) ( Math.random() * ( range + 1 ) ) + from;			
			for(int j = 0; j < i; j++){
			    if( generatedNumbers[i] == generatedNumbers[j] ){
			    	i--;
			    	break;
			    }  
			}
		}
		
		return generatedNumbers;		
	}
	
	public static int generateNumber(int from, int to, int count){
		int range = to - from;
		int generatedNumber = (int) ( Math.random() * ( range + 1 ) ) + from;
		return generatedNumber;
	}	
}
