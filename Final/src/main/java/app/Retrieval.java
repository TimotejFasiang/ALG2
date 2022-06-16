package app;

import utils.GenderChoice;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Retrieves data from user input (HRData.txt and LactateData.txt) and returns
 * it as an ArrayList.
 *
 * @author Timotej Fašiang
 */
public class Retrieval {

	/**
	 * Retrieves athlete specific lines from a Hr data file
	 *
	 * @param fileLocation Location of the Hr data file
	 * @return Returns ArrayList with athlete specific lines of hr information
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static ArrayList hrLineRetrieval(String fileLocation) throws FileNotFoundException, IOException {

		ArrayList<String> lineData = new ArrayList<>();
		try ( BufferedReader reader = new BufferedReader(new FileReader(fileLocation))) {
			String line;
			while ((line = reader.readLine()) != null) {
				lineData.add(line);
			}
		}
		return (lineData);
	}

	/**
	 * Retrieves athlete specific lines from a Lactate data file
	 *
	 * @param fileLocation Location of the Lactate data file
	 * @return Returns ArrayList with athlete specific lines of lactate
	 * information
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static ArrayList lactateLineRetrieval(String fileLocation) throws FileNotFoundException, IOException {

		ArrayList<String> lineData = new ArrayList<>();
		try ( BufferedReader reader = new BufferedReader(new FileReader(fileLocation))) {
			String line;
			while ((line = reader.readLine()) != null) {
				lineData.add(line);
			}
		}
		return (lineData);
	}

	/**
	 * Adds athlete data, including HR, excluding lactate to the athleteList
	 * ArrayList
	 *
	 * @param lines ArrayList with athlete specific lines of information with Hr
	 * @return Returns athleteList ArrayList of current athletes including HR
	 * info
	 */
	public static ArrayList<Athlete> hrRetrieval(ArrayList<String> lines) throws NumberFormatException {
		String currentLine;
		String[] separatedLineValStr;
		ArrayList<String> separatedLineVal;
		String name;
		int dob;
		GenderChoice gender;
		ArrayList<Athlete> athleteList = new ArrayList<>();
		for (int i = 0; i < lines.size(); i++) {
			currentLine = lines.get(i);
			separatedLineValStr = currentLine.split(" ");
			separatedLineVal = new ArrayList<>(Arrays.asList(separatedLineValStr));
			name = separatedLineVal.get(0);
			dob = Integer.parseInt(separatedLineVal.get(1));

			if ("MALE".equals(separatedLineVal.get(2))) {
				gender = GenderChoice.MALE;
			} else if ("FEMALE".equals(separatedLineVal.get(2))) {
				gender = GenderChoice.FEMALE;
			} else {
				gender = null;
			}
			separatedLineVal.remove(0);
			separatedLineVal.remove(0);
			separatedLineVal.remove(0);
			Athlete myAthlete = new Athlete();

			athleteList.add(myAthlete); // separatedLineVal is hr
			athleteList.get(i).setName(name);
			athleteList.get(i).setDob(dob);
			athleteList.get(i).setGender(gender);
			athleteList.get(i).setHr(separatedLineVal);

		}
		return athleteList;
	}

	/**
	 * Adds athlete data, including Lactate, excluding Hr to the athleteList
	 * ArrayList
	 *
	 * @param lines ArrayList with athlete specific lines of information with
	 * Lactate
	 * @return Returns athleteList ArrayList of current athletes including
	 * Lactate info
	 */
	public static List lactateRetrieval(ArrayList<String> lines, List<Athlete> athleteList) throws NumberFormatException {
		String currentLine;
		String[] separatedLineValStr;
		ArrayList<String> separatedLineVal;
		String name;
		int dob;
		GenderChoice gender;
		for (int i = 0; i < lines.size(); i++) {
			currentLine = lines.get(i);
			separatedLineValStr = currentLine.split(" ");
			separatedLineVal = new ArrayList<>(Arrays.asList(separatedLineValStr));
			name = separatedLineVal.get(0);
			dob = Integer.parseInt(separatedLineVal.get(1));

			if ("MALE".equals(separatedLineVal.get(2))) {
				gender = GenderChoice.MALE;
			} else if ("FEMALE".equals(separatedLineVal.get(2))) {
				gender = GenderChoice.FEMALE;
			} else {
				gender = null;
			}
			separatedLineVal.remove(0);
			separatedLineVal.remove(0);
			separatedLineVal.remove(0);

			int indice = athleteList.indexOf(Athlete.findAthleteByName(name));
			if (indice >= 0) {
				athleteList.get(indice).setLactate(separatedLineVal);
			} else if (indice == -1) {
				athleteList.add(new Athlete(name, dob, gender, separatedLineVal, 2)); // separatedLineVal is lactate
			}
		}
		return athleteList;
	}
}
