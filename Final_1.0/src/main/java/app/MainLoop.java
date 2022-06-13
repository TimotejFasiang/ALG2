package app;

import ui.Menu;

/**
 * Runs and controls the program
 *
 * @author Timotej Fašiang
 */
public class MainLoop {

	/**
	 * Controls the program
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		boolean run = true;
		while (run) { // Runs unless user exits program using menu
			int choice = Menu.menuRun(); // Runs the menu code and returns an output number from user(1=hr data 2=lactate data 3=both)

			switch (choice) {

				case 1 -> // hr data
					Processing.hrRun();
				case 2 -> // lactate data
					Processing.lactateRun();
				case 3 -> // all data
					Processing.hrlactateRun();
				case 4 -> {
					//exit
					run = false;
				}
			}
		}
	}
}
