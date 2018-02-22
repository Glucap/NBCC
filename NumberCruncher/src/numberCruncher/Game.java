package numberCruncher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Game {

	private static int currentLevel;
	
	private static int Score;
	
	private static String User;
	
	private static byte currentTrack = 0;
	
	private Level level;
	
	public void SaveGame(ArrayList <Track> TrackList){
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void SaveGame(ArrayList <Track> TrackList)
		//
		// Method parameters	:	ArrayList <Track> TrackList
		//
		// Method return		:	void
		//
		// Synopsis				:   Saves the game using the information in the Array list passed in as a parameter
		//
		// Modifications		:
		//							Date				Developer				Notes
		//							----				---------				-----
		//							unknown date 		S.Johnson				Initial setup
		//							2017-05-30			F.Melanson				Revisions and adaptation
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		
		String filename = "Data/" + User + ".txt";																	//create a string using the user's id as a filename
		try {
			FileWriter outputFile = new FileWriter(filename);														//instantiate a file writer for the filename
			
			BufferedWriter bufferedOutputFile = new BufferedWriter(outputFile);										//instantiate a buffered writer for the file writer
																					
				
			bufferedOutputFile.write(Integer.toString(Score));														//write the score to the file				
			bufferedOutputFile.newLine();
			bufferedOutputFile.write(Integer.toString(currentLevel));													//write the current level to the file
			bufferedOutputFile.newLine();
			for(int index = 0; index< TrackList.size(); index ++){													//go through the track list
				bufferedOutputFile.write(Short.toString(TrackList.get(index).getTries()));							//write how many tries are left for each track to the file
				bufferedOutputFile.newLine();
			}
																											

			
			bufferedOutputFile.close();																				//close the buffered writer									
			outputFile.close();																						//close the file writer
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();																					//if something unexpected happens, write out the call stack
		}
								
		
	}
	
	public Boolean LoadFile(){
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void LoadFile()
		//
		// Method parameters	:	
		//
		// Method return		:	Boolean
		//
		// Synopsis				:   tries to load a saved game and returns true if it can
		//
		// Modifications		:
		//							Date				Developer				Notes
		//							----				---------				-----
		//							unknown date 		S.Johnson				Initial setup
		//							2017-05-30			F.Melanson				Revisions and adaptation
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		int index;																									//index for looping over
		
		String filename = "Data/" + User + ".txt";																	//a file name using the user's ID
	
		try {
			FileReader inputFile = new FileReader(filename);														//try reading the file with his username with a new file reader
			
			BufferedReader bufferedInputFile = new BufferedReader(inputFile);										//and a new buffered reader
						
			try{
				
				
				Score = Integer.parseInt(bufferedInputFile.readLine());												//try parsing the current score as an integer
							
				currentLevel = Short.parseShort(bufferedInputFile.readLine());										//and the current level as a short
													
				newLevel(currentLevel);																				//generate a new level				
							
				for(index = 0; index< level.getTrackList().size(); index ++){										//go through the newly generated track list
					level.getTrackList().get(index)																	//and adjust the user's tries accordingly
					.setTries(Byte.parseByte(bufferedInputFile.readLine()));
					
				}
			} 
			catch(NumberFormatException e){																			//if one or more of the numbers doesn't correspond to the desired data type
				e.printStackTrace();																				//print out the call stack
			}

			
			bufferedInputFile.close();																				//close the buffered reader									
			inputFile.close();																						//close the file reader														
			} 
					
		catch (FileNotFoundException e) {																			//if the user file is not found, make a new one
			Score = 0;																								//set score to 0
			currentLevel = 1;																						//set level to 1
			newLevel(currentLevel);																					//generate a new level					
																																		
			return false;
				
					
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	return true;																								//the user was on file, return true
}				
	
					
		

							
	
	public boolean nextTrack(){
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	boolean generateTrackList()
		//
		// Method parameters	:
		//
		// Method return		:	boolean
		//
		// Synopsis				:   Method that sets the active track to the next unsolved track
		//
		// Modifications		:
		//							Date				Developer				Notes
		//							----				---------				-----
		//							2017-05-30			F.Melanson				Initial setup
		//							2015-06-02			F.Melanson				Seperate method with new functionality
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		int looper = 0;																									//local int for looping
		
		currentTrack++;																									//add one to the current track
		
		if(currentTrack >= level.getTrackList().size())																	//current track is outside of the array list of tracks	
			currentTrack = 0;																							//set it to the beginning of the array list
		
		while (this.level.getTrackList().get(currentTrack).isCorrect()){												//while the current track is correct or solved
			currentTrack++;																								//go to the next one
			looper ++;																									//increment the loop
			
			if(currentTrack >= level.getTrackList().size())																//current track is outside of the array list of tracks	
				currentTrack = 0;																						//set it to the beginning of the array list
			
			if (looper >= level.getTrackList().size())																	//if we go through the whole array and haven't found an unsolved track
				return false;																							//there is no next unsolved track
			
		}
		return true;																									//once we have the next unsolved track, return true
	}
	
	
	public Level newLevel(int t_level){
		
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	Level newLevel(int t_level)
		//
		// Method parameters	:
		//
		// Method return		:	Level
		//
		// Synopsis				:   Method that generates a new Level object
		//
		// Modifications		:
		//							Date				Developer				Notes
		//							----				---------				-----
		//							2017-05-30			F.Melanson				Initial setup
		//							2015-06-02			F.Melanson				Seperate method with new functionality
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		int counter;																									//counter for looping
		
		short t_tries;																									//local variable to store tries
		
		currentTrack = 0;
		
		if (this.level!= null){																							//if there is a track list
			
			for (counter = 0; counter < this.level.getTrackList().size(); counter++){									//go through the track list that currently exists
				
				t_tries = this.level.getTrackList().get(counter).getTries();											//set temporary variable equal to current left over tries
				
				Score += 10 * t_tries;																					//add 10 points per left over try
				
				while(t_tries >= 3){												
					Score += 50;																						//add a bonus 50 point per 3 left over try
					t_tries =-3;
				}
			}
			
			this.level.getTrackList().clear();																			//clear the track list
		}

		
		if (t_level<10)																									//depending on the current level, generate a new 
			level = new Easy(currentLevel*10);																			//easy level
	
		else if(t_level > 9 && currentLevel < 20)
			level = new Moderate((currentLevel-9)*100);																	//moderate level

		else if (t_level > 19)
			level = new Difficult((currentLevel-19)*1000);																//or difficult level
	
		
		return level;																									//return level
		
	}
		
		
		


	public int getCurrentLevel() {
		return currentLevel;																							//returns the current level
	}

	public void setCurrentLevel(int currentLevel) {
		if (currentLevel > 0)		
			Game.currentLevel = currentLevel;																			//sets the current level to the desired level(need to set limits
	}

	public int getScore() {
		return Score;																									//return the current score
	}

	public void setScore(int score) {
		Score = score;																									//set the current score
	}

	public String getUser() {
		return User;																									//returns the username
	}

	public void setUser(String user) {
		User = user;																									//sets the username
	}

	public byte getCurrentTrack() {
		return currentTrack;																							//returns the current track (to be used for guess input)
	}

	public void setCurrentTrack(byte currentTrack) {
		Game.currentTrack = currentTrack;																				//sets the current track (to be used for guess input
	}
	
	public void setLevel(Level level){																					//set level to desired level of difficulty
		this.level = level;
	}
	
	public Level getLevel(){																							//return the current level of difficulty
		return this.level;
	}


}
