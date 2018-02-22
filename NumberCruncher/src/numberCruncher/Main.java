package numberCruncher;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class Main {
	
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
				// Method				:	void main(String[] args)
				//
				// Method parameters	:	String[] args
				//
				// Method return		:	void
				//
				// Synopsis				:   main method of the game
				//
				// Modifications		:
				//							Date				Developer				Notes
				//							----				---------				-----
				//							2017-05-30			F.Melanson				Initial setup 
				//
				// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		//--------------------------------------------------------------------------------------------------------------------
		//												Splash Screen

		JWindow window = new JWindow();																							//create a JWindow to display the splash screen
		window.getContentPane().add(
		    new JLabel("", new ImageIcon("Images/splash.gif"), SwingConstants.CENTER));											//create a JLabel with my image in the window
		window.setBounds(500, 150, 480, 270);																					//set the size of the window
		window.setVisible(true);
		try {
		    Thread.sleep(2766);																									//sleep until the animation is done
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		window.setVisible(false);																								//set window to invisible
		window.dispose();																										//get rid of the window
		
		//												End Splash Screen
		//---------------------------------------------------------------------------------------------------------------------
		NumberCrunch.getGame().setUser(JOptionPane.showInputDialog("Please input your user ID"));								//get the user to input their ID
			if (!NumberCrunch.getGame().LoadFile()) {																			//load the user's file or create a new one if we can't load it
			 int t_level=0;																										//temporary variable to store the chose level
			 boolean valid = false;
			 
				 while ((t_level < 1 || t_level > 3)||!valid){																	//while the temporary variable is not between 1 or 3
					 																											//and it is not a valid number																							
					try{
					  t_level = Integer.parseInt(JOptionPane.showInputDialog														//ask the user for which level they want
						 ("What difficulty would you like to start on?\n\n1 = Easy\n\n2 = Moderate\n\n3 = Difficult"));
					 
					 valid = true;
					 }
					
			 		catch(NumberFormatException e){
			 			e.printStackTrace();
				  }
			 	
					 
				 }
			 
			 if (t_level==1){																									//if they chose easy, make a new easy level

				 NumberCrunch.getGame().setCurrentLevel((short) 1);																//start the player on level 1
			}
			 else if (t_level == 2){																							//if they chose moderate, make a new moderate level
				
				 NumberCrunch.getGame().setCurrentLevel((short) 10);															//start the player on level 10
			 }
			 else if (t_level== 3){ 																							//if the player chose difficult, make a new difficult level
				
				 NumberCrunch.getGame().setCurrentLevel((short) 20);															//start the player on level 20															
			 }	
				 
			 NumberCrunch.getGame().newLevel(NumberCrunch.getGame().getCurrentLevel());


			
			 
			}
			NumberCrunch.UserInterface();																						//load the interface
			}
		
	}


