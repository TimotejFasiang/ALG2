package utils;

import java.time.Year;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Has extra utilities for my program
 *
 * @author Timotej Fašiang
 */
public class Utils {

	/**
	 * Calculates the maximum reached lactate value
	 *
	 * @param lactateData ArrayList containing Lactate data
	 * @return Returns the highest lactate value
	 */
	public static Double maxLactate(ArrayList<String> lactateData) {
		Double max = 0.0;
		for (int i = 0; i < lactateData.size(); i++) {
			if (Double.valueOf(lactateData.get(i)) > max) {
				max = Double.valueOf(lactateData.get(i));
			}
		}
		return max;
	}

	/**
	 * Calculates training HR zones
	 *
	 * @param dob dob
	 * @return Returns ArrayList containing training HR zones
	 */
	public static ArrayList<String> zoneHR(int dob) {
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

	/**
	 * "ArrayList.Contains()" method, except it can be used for Enums.
	 *
	 * @param test is the input string to be checked
	 * @return Returns either true or false depending on whether the input is in
	 * the MenuChoice Enum or not
	 */
	public static boolean Contains(String test) {
		for (MenuChoice c : MenuChoice.values()) {
			if (c.name().equals(test)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Tests whether the input matches the regular expression(any numbers,
	 * possibly followed by a "." then followed by more numbers) Ex: 683.56129
	 * matches; 10010110 matches; 54+320 does not match
	 *
	 * @param test is the input string to be checked
	 * @return Returns either true or false depending on whether the input
	 * follows the regex or not
	 */
	public static boolean onlyNum(String test) {
		Pattern p = Pattern.compile("[0-9]+\\.*[0-9]+");
		Matcher m = p.matcher(test);
		boolean b = m.matches();
		return b;
	}
}
