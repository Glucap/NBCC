package numberCruncher;

public class Difficult extends Level {
	
	Difficult(int maxNum){
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	Difficult(short maxNum)
		//
		// Method parameters	:	short maxNum
		//
		// Method return		:	void
		//
		// Synopsis				:   constructor that uses the desired maximum number to be guessed as a parameter
		//
		// Modifications		:
		//							Date				Developer				Notes
		//							----				---------				-----
		//							2017-05-30			F.Melanson				Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.setMaxNum(maxNum);																						//set the maximum number to be guessed
		this.setNumOfTracks((byte) 7);																				//7 tracks to generate
		this.setNumOfTries((byte) 11);																				//11 guesses per track
		generateTrackList();																						//generate tracks
	
	}

}