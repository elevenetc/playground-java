package su.levenetc.playground.java.rts.components;

import su.levenetc.playground.java.rts.objects.Location;

/**
 * Created by eleven on 15/10/2016.
 */
public class PositionComponent implements Component {

	private Location location;

	public PositionComponent(Location location) {
		this.location = location;
	}

	public Location getCurrent() {
		return location;
	}
}
