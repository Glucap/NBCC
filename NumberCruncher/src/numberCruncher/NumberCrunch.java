package numberCruncher;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NumberCrunch extends JFrame {
	
	private ArrayList <JPanel> TrackPanels = new ArrayList<JPanel>();												//an array list of JPanels to for track iteration
	
	private ArrayList <JTextField> HistoryList = new ArrayList<JTextField>();										//an array list of text fields for the guess history
	
	private ArrayList <JTextField> GuessList = new ArrayList<JTextField>();											//an array list of text fields for user guesses
	
	private ArrayList <JButton> CorrectList = new ArrayList <JButton>();											//an array list of buttons to display an image for the user to know
																													//if he is correct or not and whether his guess is too low or too high
	private ArrayList <JTextField> TriesList = new ArrayList <JTextField>();										//array list of text fields to store the amount of tries the user has left

	private static Game game = new Game();																			//new instance of a game
	private ImageIcon WrongHi = new ImageIcon(
			new ImageIcon("Images/WrongHi.png")
			.getImage().getScaledInstance(86, 45, Image.SCALE_SMOOTH));
	private ImageIcon WrongLo = new ImageIcon(			
			new ImageIcon("Images/WrongLo.png")
			.getImage().getScaledInstance(86, 45, Image.SCALE_SMOOTH));
	private ImageIcon Correct = new ImageIcon(			
			new ImageIcon("Images/Correct.png")
			.getImage().getScaledInstance(86, 45, Image.SCALE_SMOOTH));
	private ImageIcon GameOver = new ImageIcon(			
			new ImageIcon("Images/gameover.gif")
			.getImage());
	private JPanel t_panel;
	private JButton correct_1;
	private JPanel contentPane;
	private JTextField PlayerField;
	private JTextField ScoreField;
	private JTextField LevelField;
	private JTextField guessField;
	private JTextField triesField;
	private JTextField historyField;
	private JLabel MaxNumLbl;
	private JButton btnNewGame;
	private JLabel lblGameOver;

	public static Game getGame(){
		return game;																									//method returns the current game
	}
	public void UnDrawUI(){
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void UnDrawUI()
		//
		// Method parameters	:	
		//
		// Method return		:	void
		//
		// Synopsis				:   main method of the game
		//
		// Modifications		:
		//							Date				Developer				Notes
		//							----				---------				-----
		//							2017-06-01			F.Melanson				Initial setup 
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		
		game.SaveGame(NumberCrunch.getGame().getLevel().getTrackList());												//save the game state
	
		int loop, loop2;
		
		for (loop = 0; loop < 7; loop ++){																				//go through all the buttons, panels and text fields
			TrackPanels.get(loop).setVisible(false);																	//set them all to invisible
			for (loop2=0; loop2 < 5; loop2 ++){																			//second loop for the history fields since there are 5 per track
				HistoryList.get(loop * 5 + loop2).setText("");
				HistoryList.get(loop * 5 + loop2).setVisible(false);
			}
			GuessList.get(loop).setVisible(false);
			CorrectList.get(loop).setVisible(false);
			CorrectList.get(loop).setIcon(null);
			TriesList.get(loop).setVisible(false);
		}
		
	}
	public void DrawUI(){
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	DrawUI()
		//
		// Method parameters	:	
		//
		// Method return		:	void
		//
		// Synopsis				:   Method to draw the UI
		//
		// Modifications		:
		//							Date				Developer				Notes
		//							----				---------				-----
		//							2017-06-01			F.Melanson				Initial setup 
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		int loop, loop2;																							

		for (loop = 0; loop < game.getLevel().getTrackList().size(); loop ++){
			TrackPanels.get(loop).setVisible(true);
			for (loop2=0; loop2 < 5; loop2 ++)
				HistoryList.get(loop * 5 + loop2).setVisible(true);
			GuessList.get(loop).setVisible(true);
			CorrectList.get(loop).setVisible(true);
			TriesList.get(loop).setVisible(true);
		}
		
	}
	
	public void CreateUI(){	
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	CreateUI()
		//
		// Method parameters	:	
		//
		// Method return		:	void
		//
		// Synopsis				:   Method to create the user interface
		//
		// Modifications		:
		//							Date				Developer				Notes
		//							----				---------				-----
		//							2017-05-30			F.Melanson				Initial setup 
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		int historyIndex;
		int paneIndex;

		for (paneIndex = 0; paneIndex < 7; paneIndex++){																//loop that generates the entire interface

			t_panel = new JPanel();																						//creates a new panel
		
			t_panel.setBounds(184 + (104 * paneIndex), 31, 94, 437);													//places it in the window
			contentPane.add(t_panel);
			t_panel.setLayout(null);
			
			
			guessField = new JTextField();																				//create a guess field
			guessField.setBounds(4, 381, 86, 45);																		//places it at certain coordinates in the current panel
			t_panel.add(guessField);																					//add it to the current panel
			guessField.setFont(new Font("Agency FB", Font.PLAIN, 47));
			guessField.setHorizontalAlignment(SwingConstants.CENTER);
			guessField.setBackground(new Color(189, 183, 107));
			guessField.setColumns(10);
			guessField.setEditable(false);
			
			GuessList.add(guessField);																					//add the field to the array list of guess fields
			
			correct_1 = new JButton("");																				//create new button
			correct_1.setBounds(4, 327, 86, 45);																		//sets it in the current panel
			t_panel.add(correct_1);																						//add it to the current panel
			correct_1.setBorderPainted(false);
			correct_1.setDefaultCapable(false);
			correct_1.setRolloverEnabled(false);
			correct_1.setRequestFocusEnabled(false);
			correct_1.setFocusPainted(false);
			correct_1.setFocusTraversalKeysEnabled(false);
			correct_1.setFocusable(false);
			correct_1.setBackground(new Color(105, 105, 105));
			correct_1.setIcon(null);
			CorrectList.add(correct_1);																					//add the button to the list of buttons
			
			triesField = new JTextField();																				//creates a new text field for tries left
			triesField.setBounds(4, 3, 86, 45);																			//set the coordinates
			t_panel.add(triesField);																					//add to the pane
			triesField.setFont(new Font("Tahoma", Font.PLAIN, 47));
			triesField.setHorizontalAlignment(SwingConstants.CENTER);
			triesField.setEditable(false);
			triesField.setForeground(new Color(128, 128, 128));
			triesField.setBackground(new Color(0, 0, 205));
			triesField.setColumns(10);
			TriesList.add(triesField);																					//add the text field to the array list of tries
			
			
			for (historyIndex = 0; historyIndex < 5 ; historyIndex ++){													//loop to create 5 history fields
				historyField = new JTextField();																		//create field
				historyField.setBounds(4, 274 - (historyIndex * 55), 86, 45);
				t_panel.add(historyField);																				//adds it to the current panel
				historyField.setHorizontalAlignment(SwingConstants.CENTER);
				historyField.setForeground(new Color(0, 0, 0));
				historyField.setFont(new Font("Agency FB", Font.PLAIN, 47));
				historyField.setEditable(false);
				historyField.setColumns(10);
				historyField.setBackground(new Color(169, 169, 169));
				
				HistoryList.add(historyField);																			//add the panel to the history field list
			}
			
			TrackPanels.add(t_panel);																					//add panel to the panel list
		}
		
		UnDrawUI();																										//erase the user interface
				
		UpdateUI();																										//update the user interface

		DrawUI();																										//draw the user interface
	}
	
	public void UpdateUI(){
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void UpdateUI()
		//
		// Method parameters	:	
		//
		// Method return		:	void
		//
		// Synopsis				:   This method updates the user interface
		//
		// Modifications		:
		//							Date				Developer				Notes
		//							----				---------				-----
		//							2017-05-30			F.Melanson				Initial setup 
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		
		int index;
		
		for  (index = 0; index< game.getLevel().getTrackList().size(); index++){									//go through the tries list
			TriesList.get(index).setText(Short.toString(game.getLevel().getTrackList().get(index).getTries()));		//set it to the appropriate amount based on the track list
		}
		
		ScoreField.setText(Integer.toString(game.getScore()));														//set the score field to the current score
		
		LevelField.setText(Integer.toString(game.getCurrentLevel()));												//set the level field to the current level
		
		PlayerField.setText(game.getUser());																		//display the player's id
		
		MaxNumLbl.setText(Integer.toString(game.getLevel().getMaxNum()));											//update the new number to guess
		
		for(index = 0;index<game.getLevel().getTrackList().size(); index++){										//reset all the guess fields
			GuessList.get(index).setEditable(false);
			GuessList.get(index).setText("");
			GuessList.get(index).setBackground(new Color(169, 169, 169));
		
		}
			
		GuessList.get(game.getCurrentTrack()).setBackground(new Color(189, 183, 107));								//change the color of the current guess field
		GuessList.get(game.getCurrentTrack()).setEditable(true);													//make it editable
		GuessList.get(game.getCurrentTrack()).requestFocus();														//pull focus to this text field

		
		
	}

	public static void UserInterface() {
		


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumberCrunch frame = new NumberCrunch();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public NumberCrunch() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 560);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 11, 115, 491);
		contentPane.add(panel);
		panel.setLayout(null);
		
		PlayerField = new JTextField();
		PlayerField.setEditable(false);
		PlayerField.setHorizontalAlignment(SwingConstants.CENTER);
		PlayerField.setFont(new Font("Arial Narrow", Font.PLAIN, 37));
		PlayerField.setBounds(10, 70, 95, 37);
		panel.add(PlayerField);
		PlayerField.setColumns(10);
		
		JLabel lblPlayer = new JLabel("Player");
		lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer.setBounds(10, 45, 95, 14);
		panel.add(lblPlayer);
		
		JLabel lblScore = new JLabel("Score");
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setBounds(10, 229, 95, 14);
		panel.add(lblScore);
		
		ScoreField = new JTextField();
		ScoreField.setHorizontalAlignment(SwingConstants.CENTER);
		ScoreField.setFont(new Font("Arial Narrow", Font.PLAIN, 37));
		ScoreField.setEditable(false);
		ScoreField.setColumns(10);
		ScoreField.setBounds(10, 254, 95, 37);
		panel.add(ScoreField);
		
		LevelField = new JTextField();
		LevelField.setHorizontalAlignment(SwingConstants.CENTER);
		LevelField.setFont(new Font("Arial Narrow", Font.PLAIN, 37));
		LevelField.setEditable(false);
		LevelField.setColumns(10);
		LevelField.setBounds(10, 327, 95, 37);
		panel.add(LevelField);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel.setBounds(10, 302, 95, 14);
		panel.add(lblLevel);
		
		JButton btnGuess = new JButton("GUESS");																				//button to submit a guess
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int count;																										//local counter for loops
				byte t_trackNum = game.getCurrentTrack();																		//temporary track number
				short guessNum = 0;																								//local guess number


				try{
				guessNum = Short.parseShort(GuessList.get(t_trackNum).getText());												//try to parse the user's input as a short
				}
				catch(NumberFormatException e){
					guessNum = 0;																								//if you can't, the guess defaults to 0
				}
				
				for (count=4; count > 0; count --)																				//go backwards through the current track's history list
					HistoryList.get(t_trackNum * 5 + count).setText(HistoryList.get(t_trackNum * 5 + count - 1).getText());		//set the text to the previous guess
				
				HistoryList.get(t_trackNum * 5).setText(Short.toString(guessNum));												//set the latest history field to the current guess
				
				game.getLevel().getTrackList().get(t_trackNum).setGuessNum(guessNum);											//set the current guess in the current track			
				
				if (!game.getLevel().getTrackList().get(t_trackNum).isCorrect()){												//check if the guess is correct
					
					if(game.getLevel().getTrackList().get(t_trackNum).isHigher())												//if not, check if the number to guess is higher
						CorrectList.get(t_trackNum).setIcon(WrongHi);															//if it is, set the appropriate image to the button
					else
						CorrectList.get(t_trackNum).setIcon(WrongLo);															//if it is lower, set the appropriate image to the button
					
					game.getLevel().getTrackList().get(t_trackNum).setTries((short) (game.getLevel().
							getTrackList().get(t_trackNum).getTries()-1));														//remove 1 try from the track
					
					
					if(game.getLevel().getTrackList().get(t_trackNum).getTries()<1){											//if the tries fall below 1
						UnDrawUI();																								//undraw the UI
						lblGameOver.setVisible(true);																			//set the game over screen
						btnGuess.setVisible(false);																				//hide the guess button
						btnNewGame.setVisible(true);																			//show the new game button
					}
				}
				else
					CorrectList.get(t_trackNum).setIcon(Correct);																//if the guess is not wrong, it is correct
				
				if(!game.nextTrack()){																							//if you can't find a new unsolved track
					ArrayList<Short> tryList = new ArrayList<Short>();															
					for (count = 0; count < game.getLevel().getTrackList().size(); count ++)
						tryList.add(game.getLevel().getTrackList().get(count).getTries());										//store the left over tries for this level in an array list
					
					game.setCurrentLevel(game.getCurrentLevel() + 1);															//augment the level
					game.setLevel(game.newLevel(game.getCurrentLevel()));														//generate a new level
					game.getLevel().setTryList(tryList);																		//use the temporary try list to add tries to the new level
					game.setCurrentTrack((byte) 0);																				//set the current track as the first in the array
					UnDrawUI();																									//undraw the UI
					DrawUI();																									//draw the UI
				}
				UpdateUI();																										//Update the UI
			}
		});
		btnGuess.setBounds(10, 415, 95, 54);
		panel.add(btnGuess);
		
		JButton Exit = new JButton("Exit");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		Exit.setBounds(10, 11, 95, 23);
		panel.add(Exit);
		
		JLabel lblGuessTheNumber = new JLabel("Guess the number");
		lblGuessTheNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuessTheNumber.setBounds(0, 118, 115, 14);
		panel.add(lblGuessTheNumber);
		
		JLabel lblBetween = new JLabel("between");
		lblBetween.setHorizontalAlignment(SwingConstants.CENTER);
		lblBetween.setBounds(10, 137, 95, 14);
		panel.add(lblBetween);
		
		JLabel label1 = new JLabel("1");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label1.setBounds(10, 162, 95, 14);
		panel.add(label1);
		
		JLabel lblAnd = new JLabel("and");
		lblAnd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnd.setBounds(10, 175, 95, 14);
		panel.add(lblAnd);
		
		MaxNumLbl = new JLabel("");
		MaxNumLbl.setForeground(Color.RED);
		MaxNumLbl.setHorizontalAlignment(SwingConstants.CENTER);
		MaxNumLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		MaxNumLbl.setBounds(10, 193, 95, 14);
		panel.add(MaxNumLbl);
		
		btnNewGame = new JButton("New game");																						//New game button
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				game.setCurrentLevel(1);																							//reset level to 1
				game.setScore(0);																									//reset score to 0
				game.getLevel().getTrackList().clear();																				//clear trackList
				 int t_level=0;																										//temporary variable to store the chose level
				 boolean valid = false;
				 
					 while ((t_level < 1 || t_level > 3)||!valid){																	//while the temporary variable is not between 1 or 3
						 																											//and it is not a valid number																							
						try{
						  t_level = Integer.parseInt(JOptionPane.showInputDialog													//ask the user for which level they want
							 ("What difficulty would you like to start on?\n\n1 = Easy\n\n2 = Moderate\n\n3 = Difficult"));
						 
						 valid = true;
						 }
						
				 		catch(NumberFormatException e){
				 			e.printStackTrace();
					  }
				 	
						 
					 }
				 
				 if (t_level==1){																									//if they chose easy, make a new easy level
					 game.setLevel(new Easy((short) 10));
					 game.setCurrentLevel((short) 1);																				//start the player on level 1
				}
				 else if (t_level == 2){																							//if they chose moderate, make a new moderate level
					 game.setLevel(new Moderate((short)100));
					 game.setCurrentLevel((short) 10);																				//start the player on level 10
				 }
				 else if (t_level== 3){ 																							//if the player chose difficult, make a new difficult level
					game.setLevel(new Difficult((short)1000));
					game.setCurrentLevel((short) 20);																				//start the player on level 20															

				}
				 
				game.setCurrentTrack((byte) 0);																						//set the current track to 0
				lblGameOver.setVisible(false);																						//get rid of the idiot shooting guns
				UnDrawUI();																											//undraw the ui
																														
				UpdateUI();																											//update the ui
				
				DrawUI();		 																									//draw the ui
				 


				
			}
		});
		btnNewGame.setVisible(false);
		btnNewGame.setBounds(10, 415, 95, 54);
		panel.add(btnNewGame);
		
		JLabel lblTries = new JLabel("Tries");
		lblTries.setForeground(new Color(0, 0, 0));
		lblTries.setBounds(143, 50, 36, 14);
		contentPane.add(lblTries);
		
		JLabel lblGuess = new JLabel("Guess");
		lblGuess.setBounds(147, 426, 46, 14);
		contentPane.add(lblGuess);
		
		lblGameOver = new JLabel("");
		lblGameOver.setVisible(false);
		lblGameOver.setIcon(GameOver);
		lblGameOver.setBounds(250, 72, 498, 368);
		contentPane.add(lblGameOver);

		CreateUI();
		
	}
}
