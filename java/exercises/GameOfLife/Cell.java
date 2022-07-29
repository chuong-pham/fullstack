package com.skillstorm.assignments.week4.beans;

/*
 * The class holds data about a cell
 */
public class Cell {
	// Properties

		boolean alive; // TRUE is alive and FALSE is dead

		int neighbors; // The number of neighbors of a specific cell

		/**
		 * 
		 * The default constructor
		 * 
		 */

		public Cell() {

			super();

			this.alive = false;

			this.neighbors = 0;

		}

		/**
		 * 
		 * The overloaded constructor
		 * 
		 * @param alive
		 * 
		 */

		public Cell(boolean alive) {

			this();

			this.alive = alive;

		}

		/**
		 * 
		 * @return the alive
		 * 
		 */

		public boolean isAlive() {

			return alive;

		}

		/**
		 * 
		 * @param alive the alive to set
		 * 
		 */

		public void setAlive(boolean alive) {

			this.alive = alive;

		}

		/**
		 * 
		 * @return the neighbors
		 * 
		 */

		public int getNeighbors() {

			return neighbors;

		}

		/**
		 * 
		 * @param neighbors the neighbors to set
		 * 
		 */

		public void setNeighbors(int neighbors) {

			this.neighbors = neighbors;

		}
}
