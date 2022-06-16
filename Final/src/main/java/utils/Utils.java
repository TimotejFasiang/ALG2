package utils;

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
