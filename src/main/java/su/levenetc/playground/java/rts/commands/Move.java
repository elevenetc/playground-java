package su.levenetc.playground.java.rts.commands;


import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import su.levenetc.playground.java.rts.Map;
import su.levenetc.playground.java.rts.components.PositionComponent;
import su.levenetc.playground.java.rts.components.SizeComponent;
import su.levenetc.playground.java.rts.exceptions.MoveException;
import su.levenetc.playground.java.rts.objects.Location;
import su.levenetc.playground.java.rts.units.Unit;

/**
 * Created by eleven on 15/10/2016.
 */
public abstract class Move extends BasicCommand {

	protected final Location target;
	protected final PositionComponent position;
	protected final SizeComponent size;
	protected final Unit unit;
	protected final Map map;

	public Move(Location target, Unit unit, Map map) {
		this.target = target;
		this.position = unit.getComponent(PositionComponent.class);
		this.size = unit.getComponent(SizeComponent.class);
		this.unit = unit;
		this.map = map;
	}

	@Override public Single execute() {

		Location current = position.getCurrent();

		return map.getPathFor(unit)
				.from(current)
				.to(target)
				.build()
				.flatMap(new Function<Map.Path, SingleSource<?>>() {
					@Override public Single<Object> apply(Map.Path path) throws Exception {
						return Single.create(e -> {
							try {
								move(path);
								e.onSuccess(Move.this);
							} catch (MoveException t) {
								e.onError(t);
							}
						});
					}
				});


	}

	abstract void move(Map.Path path) throws MoveException;
}
