package numberCruncher;

public class Track {

	private short guessNum;
	private short randNum;
	private boolean correct;
	private boolean higher;
	private short tries;
	
	Track(int maxNum, short tries, RNG rng){
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	Track(short MaxNum, byte tries, RNG rng)
		//
		// Method parameters	:	short MaxNum, byte tries, RNG rng
		//
		// Method return		:	void
		//
		// Synopsis				:   constructor that uses the maximum number for the level, the amount of tries, and a 
		//							random number generator to generate a track
		//
		// Modifications		:
		//							Date				Developer				Notes
		//							----				---------				-----
		//							2017-05-30			F.Melanson				Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		setRandNum(maxNum, rng);																					//generates a random number for this track
		correct = false;
		setTries(tries);																							//sets the amount of tries
	}
	public void setHigher(){

	
	}
	
		
	public void setRandNum(int maxNum, RNG rng) {
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void setRandNum(short maxNum, RNG rng)
		//
		// Method parameters	:	short maxNum, RNG rng
		//
		// Method return		:	void
		//
		// Synopsis				:   method that sets the random number using the maximum desired number and the level's
		//							random number generator
		//
		// Modifications		:
		//							Date				Developer				Notes
		//							----				---------				-----
		//							2017-05-30			F.Melanson				Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.randNum = rng.getRandNum(maxNum);																		//this track's random number is equal to the one we generate
	}
	
	
	public short getRandNum() {
		return randNum;																								//return the current random number
	}
		
	public short getGuessNum() {
		return guessNum;																							//return the guess number
	}
	
	public void setGuessNum(short guessNum) {
		this.guessNum = guessNum;																					//set the user's guess
	}
	
	
	public boolean isCorrect() {
		if(guessNum == randNum)																						//if the guess number matches the random number
			correct = true;																							//it is correct
		else 																										//else
			correct = false;																						//it isn't
		return correct;																								//return whether the guess is correct or not
	}
	
	public boolean isHigher(){
		
		if (guessNum > randNum)																						//if the guess number is higher than the random number
			higher = true;																							//it is higher
		else																										//else
			higher = false;																							//it is not higher
		return higher;																								//return the current value of "higher"
	}
	
	public short getTries() {
		return tries;																								//return the amount of tries left
	}

	public void setTries(short tries) {
		this.tries = tries;																							//set the amount of tries left
	}
}
