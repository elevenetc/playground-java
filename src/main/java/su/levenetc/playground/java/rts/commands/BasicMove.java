package su.levenetc.playground.java.rts.commands;

import su.levenetc.playground.java.rts.Map;
import su.levenetc.playground.java.rts.exceptions.MoveException;
import su.levenetc.playground.java.rts.objects.Location;
import su.levenetc.playground.java.rts.units.Unit;

/**
 * Created by eleven on 15/10/2016.
 */
public class BasicMove extends Move {

	public BasicMove(Location target, Unit unit, Map map) {
		super(target, unit, map);
	}

	@Override void move() throws MoveException {
		Location current = position.getCurrent();
		if (!current.equals(target)) {
			Map.Path path = map.getPathFor(unit).from(current).to(target).build(unit);
			if (path.size() > 0) {

			}
		}
	}
}
