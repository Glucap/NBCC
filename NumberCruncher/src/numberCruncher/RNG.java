package numberCruncher;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class RNG {
	
	private static ArrayList<Number> NumList = new ArrayList<Number>();												//an array list of number objects to figure out the mode
	
	private static Random rand = new Random();																		//a new random object to generate random numbers
	
	private Number num;																								//a number object
	
	private static ArrayList<Short> RandList= new ArrayList <Short>();												//an array list of random shorts

	
	
	public void generateNumList(int maxNum) {
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	generateNumList(short maxNum)
		//
		// Method parameters	:	short MaxNum
		//
		// Method return		:	void
		//
		// Synopsis				:   a method to generate a list of number objects
		//
		// Modifications		:
		//							Date				Developer				Notes
		//							----				---------				-----
		//							2017-05-30			F.Melanson				Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		int index;																									//a counter index for loops
		
		NumList.clear();																							//clear the current NumList

		
		for(index = 0 ;index < maxNum; index ++){																	//loop as many times as the maximum number we want
			
			num = new Number();																						//instantiate a new Number object
			
			num.setID((short) (index + 1));																			//set the id equal to the current index + 1 so we have numbers from 1 to maxNum
			
			NumList.add(num);																						//add the number to the number list
			
		}
		
	}



	public void generateRandList(int maxNum) {
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	generateRandList(short MaxNum)
		//
		// Method parameters	:	short MaxNum
		//
		// Method return		:	void
		//
		// Synopsis				:   a method to generate a list of random shorts
		//
		// Modifications		:
		//							Date				Developer				Notes
		//							----				---------				-----
		//							2017-05-30			F.Melanson				Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		short t_short;																								//a temporary short
		
		RandList.clear();																							//clear the random list
		
		while (RandList.size() < 1000){																				//while we have less than 1000 numbers
			
			t_short = (short) (rand.nextInt(maxNum)+ 1);															//generate a random number between 1 and our maximum number
			
			RandList.add(t_short);																					//add it to the list
			
		}
	}

	public short getRandNum(int maxNum){
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	getRandNum(short maxNum)
		//
		// Method parameters	:	short MaxNum
		//
		// Method return		:	short
		//
		// Synopsis				:   method that checks the random list against the number list to get the mode
		//
		// Modifications		:
		//							Date				Developer				Notes
		//							----				---------				-----
		//							2017-05-30			F.Melanson				Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		
		boolean done = false;																						//boolean to determine if we have our random number... we do not
		int index1, index2;																							//indexes to loop over
		
		while(!done){																								//while we don't have the number, do this code
		this.generateNumList(maxNum);																				//generate a list of numbers
		this.generateRandList(maxNum);																				//generate a random list
			
			
			for (index1=0 ; index1 < RandList.size(); index1++){													//loop through the random list
					index2 = 0;																						//set the second index to 0
					while(!(NumList.get(index2).getID() == RandList.get(index1))){									//while we don't have a match
						index2 ++;																					//keep going
					}
					NumList.get(index2).addFrequency();																//when we match, add to the number object's frequency
		
			}
	
			NumList.sort(Comparator.comparing(Number::getFrequency).reversed());									//sort the list to get the bigger numbers first based on their frequency
		
		
		
		if (NumList.get(0).getFrequency() > NumList.get(1).getFrequency())											//if the first object in the list has a higher frequency than the second
			done = true;																							//we are done
		
		}

		return NumList.get(0).getID();																				//return the ID of the first number in the list
		
	}
	
	public ArrayList<Number> getNumList() {								
		return NumList;																								//return the list of numbers
	}
	
	public ArrayList<Short> getRandList() {
		return RandList;																							//return the list of random shorts
	}
}
	

