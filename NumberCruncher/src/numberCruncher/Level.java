package numberCruncher;

import java.util.ArrayList;

public class Level {
	

	private RNG rng = new RNG();																			//a random number generator to be used for this level
	private int MaxNum;																						//the maximum value number for this level
	private ArrayList <Track> TrackList= new ArrayList<Track>();											//an array list of tracks to keep track of all the numbers to guess and other information
	private ArrayList <Short> TryList= new ArrayList<Short>();												//an array list of shorts to store the guesses left over from previous levels
	private byte numOfTracks;																				//how many tracks will be generated this level
	private short numOfTries;
	
	
	public void generateTrackList(){
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	generateTrackList()
		//
		// Method parameters	:
		//
		// Method return		:	void
		//
		// Synopsis				:   Method that generates tracks and add them to the track list
		//
		// Modifications		:
		//							Date				Developer				Notes
		//							----				---------				-----
		//							2017-05-30			F.Melanson				Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		int counter;																							//counter for looping 
		int index;
		
		
		Track t;																								//new track

		
		for(counter = 0; counter<numOfTracks;counter ++){														//create the desired amount of tracks
				
			t = new Track(this.MaxNum, this.numOfTries, rng);													//create a new track with the current maximum number to guess and add tries
			
			for (index = 0; index< TrackList.size(); index ++)													//go through the track list									
				if (t.getRandNum() == TrackList.get(index).getRandNum()){										//if the new track's random number exists
					t.setRandNum(this.MaxNum, rng);																//generate a new one
					index = 0;																					//go through the whole list again
				}
			if (counter < TryList.size())
				t.setTries((short) (t.getTries()+TryList.get(counter)));										//add tries to the track from the previous level
		
			TrackList.add(t);																					//add the track to the list
			
		}
			
		
	}
	
	public ArrayList<Track> getTrackList(){
		return this.TrackList;																					//returns the track list for this level
	}

	public int getMaxNum() {
		return MaxNum;																							//returns the maximum number for this level
	}

	public void setMaxNum(int maxNum) {
		MaxNum = maxNum;																						//method sets the maximum number for this level
	}

	public byte getNumOfTracks() {
		return numOfTracks;																						//returns number of tracks for this level
	}

	public void setNumOfTracks(byte numOfTracks) {
		this.numOfTracks = numOfTracks;																			//sets the number of tracks for this level
	}

	public short getNumOfTries() {
		return numOfTries;																						//returns the number of tries for this level
	}

	public void setNumOfTries(short numOfTries) {
		this.numOfTries = numOfTries;																			//sets the number of tries for this level
	}	


	public ArrayList <Short> getTryList() {																		//returns the TryList						
		return TryList;
	}

	public void setTryList(ArrayList <Short> tryList) {															//set the TryList equal to an array list of shorts
		int loop;
		for (loop = 0; loop < tryList.size(); loop++)															//add the tries from the input trylist to the current track
			TrackList.get(loop).setTries((short) (TrackList.get(loop).getTries() + tryList.get(loop)));
		TryList = tryList;
	}
}