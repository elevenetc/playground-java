package su.levenetc.algorithms.comparators;

import su.levenetc.algorithms.enums.UserStatus;
import su.levenetc.algorithms.utils.Out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by levenetc on 17/07/15.
 */
public class CheckComparator {
	public static void testUsersStatuses() {
		List<String> statuses = new ArrayList<>();
		statuses.add(UserStatus.NORMAL);
		statuses.add(UserStatus.INVITED);
		statuses.add(UserStatus.NORMAL);
		statuses.add(UserStatus.INVITED);
		statuses.add(UserStatus.INVITED);
		statuses.add(UserStatus.INVITER);
		statuses.add(UserStatus.APPOINTMENT);
		statuses.add(UserStatus.NORMAL);
		Out.pln(statuses);
		Collections.sort(statuses, new PinViewsComparator());
		Out.pln(statuses);
	}
}
