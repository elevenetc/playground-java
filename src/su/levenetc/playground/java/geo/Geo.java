package su.levenetc.playground.java.geo;

import su.levenetc.playground.java.utils.Out;

/**
 * Created by levenetc on 09/07/15.
 */
public class Geo {

	private static final MapPoint NW = new MapPoint(56.422339f, 43.728815f);
	private static final MapPoint SE = new MapPoint(56.410876f, 43.753642f);

	public static void relativePoint() {
		new MapPoint(56.417511f, 43.74684f, "p-a", "", NW, SE);
	}

	public static class MapPoint {

		String id;
		float px;
		float py;
		float lat;
		float lon;
		//RectF viewBounds = new Rect();
		String name;
		boolean isSelected;

		public MapPoint(float lat, float lon) {
			this.lat = lat;
			this.lon = lon;
		}

		public MapPoint(float lat, float lon, String name, String id, MapPoint nw, MapPoint se) {
			this.lat = lat;
			this.lon = lon;
			this.name = name;
			this.id = id;

			float latP = Math.abs(nw.lat - se.lat);
			float lonP = Math.abs(nw.lon - se.lon);
			float lt = Math.abs(lat - nw.lat) / latP;
			float ln = Math.abs(lon - nw.lon) / lonP;

			Out.pln(lt);
			Out.pln(ln);
		}

		public MapPoint(float px, float py, float lat, float lon, String name) {
			this.lat = lat;
			this.lon = lon;
			this.px = px;
			this.py = py;
			this.name = name;
		}
	}

}
