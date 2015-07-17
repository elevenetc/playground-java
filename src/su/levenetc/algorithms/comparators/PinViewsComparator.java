package su.levenetc.algorithms.comparators;

import su.levenetc.algorithms.enums.UserStatus;

import java.util.Comparator;


/**
 * Created by levenetc on 17/07/15.
 */
public class PinViewsComparator implements Comparator<String> {
	@Override
	public int compare(String leftStatus, String rightStatus) {
		if (leftStatus.equals(rightStatus)) return 0;
		return order(leftStatus) - order(rightStatus);
	}

	private int order(String status) {
		if (UserStatus.APPOINTMENT.equals(status)) {
			return 1;
		} else if (UserStatus.INVITED.equals(status)) {
			return 2;
		} else if (UserStatus.INVITER.equals(status)) {
			return 3;
		} else if (UserStatus.NORMAL.equals(status)) {
			return 4;
		} else {
			return 5;
		}
	}
}