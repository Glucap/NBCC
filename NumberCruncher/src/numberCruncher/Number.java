package numberCruncher;

public class Number {
	
	private short ID;						//a short to identify the number
	private int Frequency;					//a frequency counter to know how often this number appears in a list
	
	public short getID() {
		return this.ID;						//return the id of the number
	}
	
	public void setID(short iD) {
		this.ID = iD;						//set the id of the number
	}
	
	public int getFrequency() {
		return this.Frequency;				//return the frequency of the number
	}
	
	public void resetFrequency() {
		this.Frequency = 0;					//reset the frequency to 0
	}
	
	public void addFrequency(){
		this.Frequency ++;					//add 1 to the frequency
	}

}
