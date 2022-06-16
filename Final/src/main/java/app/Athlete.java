package app;

import java.time.Year;
import utils.GenderChoice;
import java.util.ArrayList;

interface PersonInterface {

	void setName(String name);

	void setDob(int dob);

	void setGender(GenderChoice gender);

	String getName();

	int getDob();

	GenderChoice getGender();

}

/**
 * Contains attributes and methods related to the Athlete class
 *
 * @author Timotej Fašiang
 */
public class Athlete implements PersonInterface {

	private int dob;
	private String name;
	private GenderChoice gender;
	private ArrayList<String> hr;
	private ArrayList<String> lactate;

	/**
	 * Calculates training HR zones
	 *
	 * @return Returns ArrayList containing training HR zones
	 */
	public ArrayList<String> zoneHR() {
		int age = Year.now().getValue() - dob;
		int maxHR = 220 - age;
		int up5 = maxHR;
		int down5 = Math.toIntExact((Math.round(0.95 * maxHR)));
		int up4 = maxHR;
		int down4 = Math.toIntExact((Math.round(0.90 * maxHR)));
		int up3 = Math.toIntExact((Math.round(0.87 * maxHR)));
		int down3 = Math.toIntExact((Math.round(0.95 * maxHR)));
		int up2 = Math.toIntExact((Math.round(0.85 * maxHR)));
		int down2 = Math.toIntExact((Math.round(0.75 * maxHR)));
		int up1 = Math.toIntExact((Math.round(0.75 * maxHR)));
		int down1 = Math.toIntExact((Math.round(0.65 * maxHR)));
		String zone1 = ("Zone 1: " + down1 + " - " + up1);
		String zone2 = ("Zone 2: " + down2 + " - " + up2);
		String zone3 = ("Zone 3: " + down3 + " - " + up3);
		String zone4 = ("Zone 4: " + down4 + " - " + up4);
		String zone5 = ("Zone 5: " + down5 + " - " + up5);

		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add(zone1);
		arrayList.add(zone2);
		arrayList.add(zone3);
		arrayList.add(zone4);
		arrayList.add(zone5);
		return arrayList;
	}

	public Double maxLactate() {
		Double max = 0.0;
		for (int i = 0; i < lactate.size(); i++) {
			if (Double.valueOf(lactate.get(i)) > max) {
				max = Double.valueOf(lactate.get(i));
			}
		}
		return max;
	}

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
	 * Sets dob
	 *
	 * @param dob dob to be set
	 */
	@Override
	public void setDob(int dob) {
		this.dob = dob;
	}

	/**
	 * Sets name
	 *
	 * @param name name to be set
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets gender
	 *
	 * @param gender gender to be set
	 */
	@Override
	public void setGender(GenderChoice gender) {
		this.gender = gender;
	}

	/**
	 * Sets HR data
	 *
	 * @param hr HR data in ArrayList format
	 */
	public void setHr(ArrayList<String> hr) {
		this.hr = new ArrayList<>(hr);
	}

	/**
	 * Sets Lactate data
	 *
	 * @param lactate Lactate data in ArrayList format
	 */
	public void setLactate(ArrayList<String> lactate) {
		this.lactate = new ArrayList<>(lactate);
	}

	/**
	 * Gets dob
	 *
	 * @return Returns dob
	 */
	@Override
	public int getDob() {
		return dob;
	}

	/**
	 * Gets name
	 *
	 * @return Returns name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Gets gender
	 *
	 * @return Returns gender
	 */
	@Override
	public GenderChoice getGender() {
		return gender;
	}

	/**
	 * Gets Hr data
	 *
	 * @return Returns Hr in ArrayList format
	 */
	public ArrayList<String> getHr() {
		return new ArrayList<>(hr);
	}

	/**
	 * Gets Lactate data
	 *
	 * @return Returns Lactate data in ArrayList format
	 */
	public ArrayList<String> getLactate() {
		return new ArrayList<>(lactate);
	}

	/**
	 * Default Athlete constructor
	 */
	public Athlete() {
		name = "";
	}

	/**
	 * Athlete constructor
	 *
	 * @param name Athlete name
	 * @param dob Athlete dob
	 * @param gender Athlete gender
	 */
	public Athlete(String name, int dob, GenderChoice gender) {
		this.name = name;
		this.dob = dob;
		this.gender = gender;
	}

	/**
	 * Athlete constructor
	 *
	 * @param name Athlete name
	 * @param dob Athlete dob
	 * @param gender Athlete gender
	 * @param hr Athlete HR data
	 */
	public Athlete(String name, int dob, GenderChoice gender, ArrayList<String> hr) {
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.hr = hr;

	}

	/**
	 * Athlete constructor
	 *
	 * @param name Athlete name
	 * @param dob Athlete dob
	 * @param gender Athlete gender
	 * @param data Athlete HR or Lactate data depending on @param type
	 * @param type Specifies if @param data is HR or Lactate data
	 */
	public Athlete(String name, int dob, GenderChoice gender, ArrayList<String> data, int type) {
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		if (type == 1) {
			hr = data;
		} else if (type == 2) {
			lactate = data;
		}

	}

	/**
	 * Athlete constructor
	 *
	 * @param name Athlete name
	 * @param dob Athlete dob
	 * @param gender Athlete gender
	 * @param hr Athlete HR data
	 * @param lactate Athlete Lactate data
	 */
	public Athlete(String name, int dob, GenderChoice gender, ArrayList<String> hr, ArrayList<String> lactate) {

		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.hr = hr;
		this.lactate = lactate;

	}
}
