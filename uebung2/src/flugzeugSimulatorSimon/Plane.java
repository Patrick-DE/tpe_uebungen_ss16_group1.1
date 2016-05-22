package flugzeugSimulatorSimon;

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
	* If the airplane is in the air
	*/
	public void stop() throws GeneralFlightSimulatorException;
	/**
	* Lets the airplane go on one more kilometer, the altitude difference is passed as parameter
	* @param additionalHeight
	* The altitude difference the airplane is ascending/descending for the next kilometer
	* positive -> ascending, negative -> descending
	* @throws GeneralFlightSimulatorException
	* If problems occur while flying.
	*/
	public void flyNextKilometer(int additionalHeight) throws GeneralFlightSimulatorException;
	
	
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
	 * Returns the height of the plane
	 * @return
	 */
	public int getheight();
	
	/**
	 * Returns the already covered distance by the plane
	 * @return
	 */
	public int getcoveredDistance();
	
}