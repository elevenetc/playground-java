package su.levenetc.playground.java.rts;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import su.levenetc.playground.java.rts.objects.Location;
import su.levenetc.playground.java.rts.units.Unit;

import java.util.HashMap;

/**
 * Created by eleven on 15/10/2016.
 */
public class Map2D implements Map {

	private HashMap<Integer, Unit> units = new HashMap<>();

	@Override public void add(Unit unit) {
		units.put(unit.getId(), unit);
	}

	@Override public void remove(Unit unit) {
		remove(unit.getId());
	}

	@Override public void remove(int id) {
		units.remove(id);
	}

	@Override public Unit get(int id) {
		return units.get(id);
	}

	@Override public PathBuilder getPathFor(Unit unit) {
		return new PathBuilderImpl(unit);
	}

	private static class PathBuilderImpl implements PathBuilder {

		private Location to;
		private Location from;
		private Unit unit;

		public PathBuilderImpl(Unit unit) {
			this.unit = unit;
		}

		@Override public PathBuilder from(Location from) {
			this.from = from;
			return this;
		}

		@Override public PathBuilder to(Location to) {
			this.to = to;
			return this;
		}

		@Override public Single<Path> build() {
			return Single.create(new SingleOnSubscribe<Path>() {
				@Override public void subscribe(SingleEmitter<Path> e) throws Exception {

				}
			});
		}
	}
}