package su.levenetc.playground.java.rts.objects;

/**
 * Created by eleven on 15/10/2016.
 */
public class Location2D implements Location {

	private int x;
	private int y;

	public Location2D(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Location2D that = (Location2D) o;

		if (x != that.x) return false;
		return y == that.y;

	}

	@Override public int hashCode() {
		int result = x;
		result = 31 * result + y;
		return result;
	}
}
