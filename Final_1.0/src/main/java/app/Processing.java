package app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Gets data from the Retrieval class, catches exceptions, and calls the Graph
 * class to turn the data into a graph.
 *
 * @author Timotej Fašiang
 */
public class Processing {

	/**
	 * Gets heart rate data from the Retrieval class, catches exceptions, and
	 * calls the Graph.hrGraph() method to turn the data into a graph.
	 */
	public static void hrRun() throws FileNotFoundException, IOException {
		// Grab hr data
		ArrayList<String> data = null;
		data = Retrieval.hrDataRetrieval();
		System.out.println("Could not retrieve hr data");
		// Print graph from data using XChart
		Graph.hrGraph(data);
	}

	/**
	 * Gets lactate data from the Retrieval class, catches exceptions, and calls
	 * the Graph.lactateGraph() method to turn the data into a graph.
	 */
	public static void lactateRun() {
		// Grab lactate data
		ArrayList<String> data = null;
		try {
			data = Retrieval.LactateDataRetrieval();
		} catch (Exception e) {
			System.out.println("Could not retrieve lactate data");
			System.exit(0);
		}
		// Print graph from data using XChart
		Graph.lactateGraph(data);
	}

	/**
	 * Gets heart rate and lactate data from the Retrieval class, catches
	 * exceptions, and calls the Graph.doubleGraph() method to turn the data
	 * into a graph.
	 */
	public static void hrlactateRun() {
		// Grab hr data
		ArrayList<String> hrdata = null;
		try {
			hrdata = Retrieval.hrDataRetrieval();
		} catch (Exception e) {
			System.out.println("Could not retrieve hr data");
			System.exit(0);
		}
		// Grab lactate data
		ArrayList<String> lactatedata = null;
		try {
			lactatedata = Retrieval.LactateDataRetrieval();
		} catch (Exception e) {
			System.out.println("Could not retrieve lactate data");
			System.exit(0);
		}

		// Print graph including both datasets using XChart
		Graph.doubleGraph(hrdata, lactatedata);
	}
}
