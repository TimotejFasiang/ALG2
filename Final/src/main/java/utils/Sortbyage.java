package utils;

import app.Athlete;
import java.util.Comparator;

/**
 * Sorts Athletes by age
 *
 * @author Timotej Fašiang
 */
public class Sortbyage implements Comparator<Athlete> {

	/**
	 * Sorts Athletes by Age
	 *
	 * @param a First Athlete to be sorted
	 * @param b Second Athlete to be sorted
	 * @return Returns
	 */
	@Override
	public int compare(Athlete a, Athlete b) {

		return a.getDob() - b.getDob();
	}
}
