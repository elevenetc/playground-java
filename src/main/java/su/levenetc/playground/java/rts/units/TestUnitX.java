package su.levenetc.playground.java.rts.units;

import su.levenetc.playground.java.rts.components.Component;
import su.levenetc.playground.java.rts.components.PositionComponent;
import su.levenetc.playground.java.rts.components.SizeComponent;
import su.levenetc.playground.java.rts.objects.Location2D;

import java.util.ArrayList;

/**
 * Created by eleven on 15/10/2016.
 */
public class TestUnitX extends BasicUnit {

	public TestUnitX(int id) {
		super(id);
		setComponents(new ArrayList<Component>() {{
			add(new SizeComponent(1, 1));
			add(new PositionComponent(new Location2D(0, 0)));
		}});
	}
}
