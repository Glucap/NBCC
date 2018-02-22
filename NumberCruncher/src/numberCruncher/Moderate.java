package numberCruncher;

public class Moderate extends Level {
	
	Moderate(int maxNum){
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	Moderate(short maxNum)
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
		
		
		this.setMaxNum(maxNum);																						//set the maximum number to the desired amount
		this.setNumOfTracks((byte) 5);																				//5 tracks to be generated
		this.setNumOfTries((byte) 7);																				//7 tries per track
		generateTrackList();																						//call the generateTrackList method
	
	}
	
}
