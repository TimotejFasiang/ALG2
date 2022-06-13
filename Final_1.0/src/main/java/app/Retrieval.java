package app;

import utils.utils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Retrieves data from user input (HRData.txt and LactateData.txt) and returns
 * it as an ArrayList.
 *
 * @author Timotej Fašiang
 */
public class Retrieval {

	/**
	 *
	 * @return Heart rate data from HRData.txt in a String ArrayList
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static ArrayList hrDataRetrieval() throws FileNotFoundException, IOException { // Returns the hrData in an ArrayList

		ArrayList<String> hrData = new ArrayList<>();
		try ( BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Timotej\\Documents\\NetBeansProjects\\Final\\src\\main\\java\\data\\HRData.txt"))) { //nazev souboru
			//file output stream for binary
			String line;
			while ((line = reader.readLine()) != null) {
				if (utils.onlyNum(line)) {
					if (Integer.valueOf(line) < 400) { // Differentiates between decimal and binary
						hrData.add(line);
					} else {
						line = String.valueOf(Integer.parseInt(line, 2));
						hrData.add(line);
					}
				} else {
					throw new hrDataFormatException("Hr data file isn't in the correct format."); // closes method
				}
			}
		}
		return (hrData);
		/* End */
	}

	/**
	 *
	 * @return Lactate data from LactateData.txt in a String ArrayList
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static ArrayList LactateDataRetrieval() throws FileNotFoundException, IOException { // Returns the lactate data in an ArrayList

		ArrayList<String> lactateData = new ArrayList<>();

		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Timotej\\Documents\\NetBeansProjects\\Final\\src\\main\\java\\data\\LactateData.txt"));
		String line = null;
		try {
			while ((line = reader.readLine()) != null) { // data is binary
				if (utils.onlyNum(line)) {
					line = String.valueOf(Integer.parseInt(line, 2));
					lactateData.add(line);
				} else {
					System.out.println("Lactate data file isn't in the correct format.");
					System.exit(0);
				}
			}
		} catch (NumberFormatException nfe) { // Data is decimal
			lactateData.add(line);
			while ((line = reader.readLine()) != null) {
				if (utils.onlyNum(line)) {
					lactateData.add(line);
				} else {
					System.out.println("Lactate data file isn't in the correct format.");
					System.exit(0);
				}
			}
		} finally {
			reader.close();
		}
		return (lactateData);
		/* End */
	}
}
