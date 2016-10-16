package su.levenetc.playground.java.rts;

import io.reactivex.Single;
import su.levenetc.playground.java.rts.objects.Location;
import su.levenetc.playground.java.rts.units.Unit;

/**
 * Created by eleven on 15/10/2016.
 */
public interface Map {

	void add(Unit unit);

	void remove(Unit unit);

	void remove(int id);

	Unit get(int id);

	PathBuilder getPathFor(Unit unit);

	interface PathBuilder {
		PathBuilder from(Location location);

		PathBuilder to(Location location);

		Single<Path> build();
	}

	interface Path {
		int size();
	}

}