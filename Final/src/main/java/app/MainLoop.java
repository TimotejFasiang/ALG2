package app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.Menu;
import utils.Sortbyage;
import utils.Sortbyname;
import utils.Utils;

/**
 * Runs and controls the program
 *
 * @author Timotej Fašiang
 */
public class MainLoop {

	/**
	 * Contains all the Athlete info
	 */
	public static List<Athlete> athleteList = new ArrayList<>();

	/**
	 * Finds Athlete from a list based on their name attribute
	 *
	 * @param name Name of the Athlete to be found
	 * @return Returns the Athlete that is associated to the name
	 */
	public static Athlete findAthleteByName(String name) {
		for (Athlete athlete : MainLoop.athleteList) {
			if (athlete.getName().equals(name)) {
				return athlete;
			}
		}
		return null;
	}

	/**
	 * Main loop
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		boolean run = true;
		while (run) {
			int choice = Menu.menuRun();

			/* Runs the menu code and returns an output number from user
			* 1 = Graph hr
			* 2 = Graph lactate
			* 3 = Graph both
			* 4 = Save individual athlete files
			* 5 = Console output all athletes sorted by name
			* 6 = Console output all athletes sorted by dob
			* 7 = exit
			 */
			ArrayList<String> hrData;
			ArrayList<String> lactateData;
			String name;
			String location;

			athleteList.clear();
			ArrayList<String> hrLines;
			try {
				hrLines = Retrieval.hrLineRetrieval("data" + File.separator + "HRData.txt");
			} catch (IOException ex) {
				System.out.println("Couldn't get HR data from file");
				break;
			}
			try {
				athleteList = Retrieval.hrRetrieval(hrLines);

			} catch (NumberFormatException ex) {
				System.out.println("Wrong dob format in HR data file");
				// nfe is caused by not being able to parse dob
				// Because of nfe throw, athlete hr and athleteList could be null. If null, athleteList can be filled by the lactateRetrieval method.
				break;
			} catch (IndexOutOfBoundsException ioobe) {
				System.out.println("Hr data is empty");
			}

			ArrayList<String> lactateLines;
			try {
				lactateLines = Retrieval.lactateLineRetrieval("data" + File.separator + "LactateData.txt");
			} catch (IOException ex) {
				System.out.println("Couldn't get lactate data from file");
				break;
			}
			try {
				athleteList = Retrieval.lactateRetrieval(lactateLines, athleteList);
			} catch (NumberFormatException ex) {
				System.out.println("Wrong dob format in lactate data file");
				// nfe is caused by not being able to parse dob
				// Because of nfe throw, athlete lactate and athleteList could be null. If null, athleteList can be filled by the hrRetrieval method.
				break;
			} catch (IndexOutOfBoundsException ioobe) {
				System.out.println("Lactate data is empty");
			}

			switch (choice) {

				case 1 -> { // graph hr data
					for (int i = 0; i < athleteList.size(); i++) {
						hrData = athleteList.get(i).getHr();
						name = athleteList.get(i).getName();
						location = "data" + File.separator + File.separator + "hrGraph" + name;
						try {
							Graph.hrGraph(hrData, name, location);
						} catch (IOException ex) {
							System.out.println("Couldn't graph data for " + name);
						} catch (NumberFormatException nfe) {
							System.out.println("HR data is in wrong format for " + name);
						}
					}
					try {
						Thread.sleep(1500);
					} catch (InterruptedException ex) {
						Logger.getLogger(MainLoop.class.getName()).log(Level.SEVERE, null, ex);
					}
				}

				case 2 -> { // graph lactate data
					for (int i = 0; i < athleteList.size(); i++) {
						lactateData = athleteList.get(i).getLactate();
						name = athleteList.get(i).getName();
						location = "data" + File.separator + File.separator + "lactateGraph" + name;
						try {
							Graph.lactateGraph(lactateData, name, location);
						} catch (IOException ex) {
							System.out.println("Couldn't graph data for " + name);
						} catch (NumberFormatException nfe) {
							System.out.println("Lactate data is in wrong format for " + name);
						}
					}
					try {
						Thread.sleep(1500);
					} catch (InterruptedException ex) {
						Logger.getLogger(MainLoop.class.getName()).log(Level.SEVERE, null, ex);
					}
				}

				case 3 -> { // graph both data sets
					for (int i = 0; i < athleteList.size(); i++) {
						hrData = athleteList.get(i).getHr();
						lactateData = athleteList.get(i).getLactate();
						name = athleteList.get(i).getName();
						location = "data" + File.separator + File.separator + "doubleGraph" + name;
						try {
							Graph.doubleGraph(hrData, lactateData, name, location);
						} catch (IOException ex) {
							System.out.println("Couldn't graph data for " + name);
						} catch (NumberFormatException nfe) {
							System.out.println("Lactate or HR data is in wrong format for " + name);
						}
					}
					try {
						Thread.sleep(1500);
					} catch (InterruptedException ex) {
						Logger.getLogger(MainLoop.class.getName()).log(Level.SEVERE, null, ex);
					}
				}

				case 4 -> { // output text file
					for (int i = 0; i < athleteList.size(); i++) {
						name = athleteList.get(i).getName();
						int dob = athleteList.get(i).getDob();
						ArrayList<String> zoneHR = Athlete.zoneHR();
						lactateData = athleteList.get(i).getLactate();
						Double maxLactate = Utils.maxLactate(lactateData);
						try {
							Writer.WriteOutput(name, zoneHR, maxLactate);
							Writer.WriteBinaryOutput(name, zoneHR, maxLactate);
							System.out.println("Athlete file for " + name + " can be found in /data folder");
						} catch (IOException ex) {
							System.out.println("Couldn't save data for " + name);
						}
					}
					try {
						Thread.sleep(1500);
					} catch (InterruptedException ex) {
						Logger.getLogger(MainLoop.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
				case 5 -> {
					Collections.sort(athleteList, new Sortbyname());
					for (int i = 0; i < athleteList.size(); i++) {
						System.out.println(athleteList.get(i).getName() + " " + athleteList.get(i).getDob());
					}
					try {
						Thread.sleep(1500);
					} catch (InterruptedException ex) {
						Logger.getLogger(MainLoop.class.getName()).log(Level.SEVERE, null, ex);
					}
				}

				case 6 -> {
					Collections.sort(athleteList, new Sortbyage());
					for (int i = 0; i < athleteList.size(); i++) {
						System.out.println(athleteList.get(i).getName() + " " + athleteList.get(i).getDob());
					}
					try {
						Thread.sleep(1500);
					} catch (InterruptedException ex) {
						Logger.getLogger(MainLoop.class.getName()).log(Level.SEVERE, null, ex);
					}
				}

				case 7 ->
					run = false;

			}
		}
	}
}
