package ua.interview.types;

public class PrimitiveTypes {
	
	int firstInt;
	int secondInt;	
	final int[] intArray = new int[2];
	
	public PrimitiveTypes(int firstInt, int secondInt) {
		this.firstInt = firstInt;
		this.secondInt = secondInt;
	}
	
	public void fillArray(int firstValue, int secondValue) {
		intArray[0] = firstValue;		
		intArray[1] = secondValue;
	}
	
	public void incrementArrayElements() {		
		for (int i=0; i<intArray.length; i++) {
			intArray[i]++;
		}
	}
	
}
