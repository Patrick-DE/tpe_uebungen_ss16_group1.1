package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.aufgabe1;

public interface Plane {
	/**
	/* Opens the doors of the airplane.
	* To be able to open the doors the airplane must stop on ground.
	* @throws GeneralFlightSimulatorException
	* If airplane is in the air or doesn’t stop on ground.
	*/
	public void openDoors() throws GeneralFlightSimulatorException;
	/**
	* Closes the doors of the airplane.
	*/
	public void closeDoors();
	/**
	* Stops the airplane when it moves on ground.
	* @throws GeneralFlightSimulatorException
	* If the airplane is still in the air
	*/
	public void stop() throws GeneralFlightSimulatorException;
	/**
	* Lets the airplane go on one more kilometer, the altitude difference is passed as parameter
	* @param additionalHeight
	* The altitude difference the airplane is ascending/descending for the next kilometer
	* positive -> ascending, negative -> descending
	* @throws GeneralFlightSimulatorException
<<<<<<< HEAD
	* If the minimum permissible height is not reached after two kilometers, the PlaneTooLowException will be thrown.
	* If the maximum permissible height is exceeded, the PlaneTooHighException will be thrown.
	* If the parameter of the method is invalid, the GeneralFlightSimulatorException will be thrown.
	* If the door is still open or if the plane would fly past the final destination the GeneralFlightSimulatorException will be thrown.

=======
	* If problems occur while flying.
>>>>>>> branch 'master' of https://github.com/Patrick-DE/tpe_uebungen_ss16_group1.1.git
	*/
	public void flyNextKilometer(int additionalHeight) throws GeneralFlightSimulatorException;
	
	/** 
	 * Prints all relevant information about the airplane
=======
	
	/**
	 * Print the Object's attributes from Touristenflugzeug:
	 * - coveredDistance
	 * - midAir
	 * - doorOpen
	 * - standingStill
	 * - height
	 */
	public void print();
	/**
	 * @return the current height is returned
=======
	
	/**
	 * Returns the height of the plane
	 * @return
>>>>>>> branch 'master' of https://github.com/Patrick-DE/tpe_uebungen_ss16_group1.1.git
	 */
	public int getheight();
	/**
	 * @return The distance which has already been covered by the plane.
=======
	
	/**
	 * Returns the already covered distance by the plane
	 * @return
>>>>>>> branch 'master' of https://github.com/Patrick-DE/tpe_uebungen_ss16_group1.1.git
	 */
	public int getcoveredDistance();
	
}