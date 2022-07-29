package com.skillstorm.assignments.week4.demo;

import java.util.Random;
import java.util.Scanner;
import com.skillstorm.assignments.week4.beans.Cell;
/*
 * The program demonstrates John Conway's Game of Life
 */

public class GameOfLifeDemo {
	//Properties
	
	private static Random random = new Random();
	
	private static final String LINEBREAK = System.getProperty("line.separator");
	
	private static final boolean LIVE = true;
	
	private static final boolean DEAD = false;
	
	private static final int ROWS = 10 + random.nextInt(20);
	
	private static final int COLS = ROWS;
	
	private static Cell[][] theLand = new Cell[ROWS][COLS];

 

	//System-generated method
	
	public static void main(String[] args) {
	
		System.out.println("****************JOHN CONWAY'S GAME OF LIFE****************");
	
		System.out.println("------------------------SIZE:" + ROWS + "x" + COLS + "------------------------");
	
		//1. Load the map of world with all dead cells
		loadMap();
	
		//2. Set the initial pattern	
		setTheFirstPattern();
		
		//3. Display the first pattern on the console before starting the game
		System.out.println("Initial pattern: ");	
		displayNextGeneration();	
		System.out.println("-----------------------------------------------------------");
	

		Scanner scanner = new Scanner(System.in);	
		System.out.print("Do you want to start the game?(Y/N): ");
		String userInput = scanner.nextLine();		
		char answer = userInput.charAt(0);
	
	 	
		while(answer == 'Y' || answer == 'y') {	
			start();	
			displayNextGeneration();
			delayOneSecond();
		}
	
		System.out.println("The program is finished!");
		
	}
			
	/*
	 * The method checks whether or not the current generation
	 * is stable and unchanged anymore
	 */
	private static int isStable() {
		int count = 0;
		
		return count;
	}
	
	
	/*
	* The method delays displaying the next generation one second
	*/	
	private static void delayOneSecond() {	
		try{		
			Thread.sleep(1000);	
		} catch (InterruptedException e) {		
			// TODO Auto-generated catch block		
			e.printStackTrace();		
		}
	
	}
	
	/*
	* The method displays only live cells' coordinates
	*/
	private static void displayLiveCells() {
	
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLS; j++) {
				if(theLand[i][j].isAlive())
					System.out.print("[" + i + "," + j + "] ");
			}	
		}	
	}
	
	/*
	* The method initializes the land with all dead cells
	*/	
	private static void loadMap() {
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLS; j++) {
				theLand[i][j] = new Cell(DEAD);	
			}	
		}	
	}
	
	/*
	* The method displays the whole map on the console
	*/
	private static void displayNextGeneration() {
	
		final StringBuffer buffer = new StringBuffer();	
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLS; j++) {
				if(theLand[i][j].isAlive())	
					buffer.append("x ");	
				else
					buffer.append(". ");	
			}	
			buffer.append(LINEBREAK);	
		}
		System.out.println(buffer.toString());	
	}
		
	/*
	* The method sets up the first living cells on the map
	*/
	private static void setTheFirstPattern() {	
	//Pattern: Blinker	
	//theLand[3][4].setAlive(LIVE);
	//theLand[3][5].setAlive(LIVE);
	//theLand[3][6].setAlive(LIVE);
		
	//Pattern: Block	
	//theLand[2][4].setAlive(LIVE);	
	//theLand[2][5].setAlive(LIVE);
	//theLand[3][4].setAlive(LIVE);
	//theLand[3][5].setAlive(LIVE);
	
	 
	
	//Pattern: Glider	
	theLand[2][4].setAlive(LIVE);	
	theLand[3][5].setAlive(LIVE);
	theLand[4][3].setAlive(LIVE);
	theLand[4][4].setAlive(LIVE);
	theLand[4][5].setAlive(LIVE);
		
	}
		
	/*
	* The method scans the whole map and calculates
	* the number of neighbors of each cell
	*/	
	private static void scanNeighbors() {	
		try {
			for(int i = 0; i < ROWS; i++) {	
				for(int j = 0; j < COLS; j++) {	
					if((i-1)>= 0 && (j-1) >= 0 && (i+1) < ROWS && (j+1) < COLS) {	
						int neighbors = 0;	
						//1. Look to the left	
						if(theLand[i][j-1].isAlive())	neighbors++;
						//2. Look to the right
						if(theLand[i][j+1].isAlive()) 	neighbors++;
						//3. Look up
						if(theLand[i-1][j].isAlive())	neighbors++;
						//4. Look down
						if(theLand[i+1][j].isAlive())	neighbors++;
						//5. Look upper right
						if(theLand[i-1][j+1].isAlive())	neighbors++;
						//6. Look upper left
						if(theLand[i-1][j-1].isAlive())	neighbors++;
						//7. Look lower right
						if(theLand[i+1][j+1].isAlive())	neighbors++;
						//8. Look lower left
						if(theLand[i+1][j-1].isAlive())	neighbors++;
						//Save the number of neighbors.	
						theLand[i][j].setNeighbors(neighbors);
					}
				}
			}
		}
		catch(ArrayIndexOutOfBoundsException e) {	
			e.printStackTrace();	
		}
	}

	/*
	 * The method starts the game
	 */
	private static void start() {
		Cell currentCell;
		//Always looking for neighbors every generation
		scanNeighbors();
		for(int i = 1; i < ROWS - 1; i++) {
			for(int j = 1; j < COLS - 1; j++) {					
				currentCell= theLand[i][j];
				if(currentCell.isAlive()) {
					//Any live cell with fewer than two live neighbors dies
					if(currentCell.getNeighbors() < 2 || currentCell.getNeighbors() > 3)
						currentCell.setAlive(DEAD);

				}
				//Any dead cell with three live neighbors becomes a live cell.
				else if(currentCell.getNeighbors() == 3)
					currentCell.setAlive(LIVE);
				
				//All other live cells die in the next generation. 
				//Similarly, all other dead cells stay dead.

			}
		}
	}
}