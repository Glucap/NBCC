package numberCruncher;

public class Easy extends Level {
	
	Easy(int maxNum){
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	Easy(short maxNum)
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
		this.setNumOfTracks((byte) (3));																			//3 tracks to be generated
		this.setNumOfTries((byte) 5);																				//5 tries per track
		generateTrackList();																						//call the generateTrackList method

	}
		
}
