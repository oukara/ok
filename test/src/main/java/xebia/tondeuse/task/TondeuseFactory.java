package xebia.tondeuse.task;

public interface TondeuseFactory {

	/**
	 * Read  file param
	 */
	void loadFile();
	
	/**
	 * Get new direction of machine accordinf to the currentDirection and the rotation
	 * @param currentDir
	 * @param commande
	 * @return
	 */
	char getNewDirection(char currentDir, char rotation);

	/**
	 * Start all machines
	 */
	void startMachines();

}
