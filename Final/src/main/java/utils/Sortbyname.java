package utils;

import java.util.Comparator;
import app.Athlete;

/**
 * Sorts Athletes by name
 *
 * @author Timotej Fašiang
 */
public class Sortbyname implements Comparator<Athlete> {

	/**
	 * Sorts Athletes by name
	 *
	 * @param a First Athlete to be sorted
	 * @param b Second Athlete to be sorted
	 * @return Returns
	 */
	@Override
	public int compare(Athlete a, Athlete b) {

		return a.getName().compareTo(b.getName());
	}
}
