package rts;

import org.junit.Test;
import su.levenetc.playground.java.rts.Map;
import su.levenetc.playground.java.rts.Map2D;
import su.levenetc.playground.java.rts.units.BasicUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by eleven on 15/10/2016.
 */
public class MapTests {
	@Test public void testMap() {
		Map map = new Map2D();

		BasicUnit unit0 = new BasicUnit(0);
		BasicUnit unit1 = new BasicUnit(1);

		map.add(unit0);
		map.add(unit1);
		map.remove(1);

		assertEquals(unit0, map.get(0));
		assertEquals(null, map.get(1));
	}
}
