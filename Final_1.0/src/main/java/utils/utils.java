package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Has extra utilities for my program
 *
 * @author Timotej Fašiang
 */
public class utils {

	/**
	 * "ArrayList.contains()" method, except it can be used for Enums.
	 *
	 * @param test is the input string to be checked
	 * @return Either true or false depending on whether input is in Enum choice
	 * or not
	 */
	public static boolean contains(String test) {

		for (choice c : choice.values()) {
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
	 * @return Either true or false depending on whether the input follows the
	 * regex or not
	 */
	public static boolean onlyNum(String test) {

		Pattern p = Pattern.compile("[0-9]+\\.*[0-9]+");
		Matcher m = p.matcher(test);
		boolean b = m.matches();

		return b;
	}
}
