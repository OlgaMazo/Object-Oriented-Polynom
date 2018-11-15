package myMath;

import java.util.Comparator;

public class Monom_Comperator implements Comparator<Monom> {

	/**
	 * compare
	 * Compare by the monoms power in the polynom
	 */
	public int compare(Monom arg0, Monom arg1) {
		return arg0.get_power() - arg1.get_power();
	}
}
