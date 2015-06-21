package su.levenetc.algorithms.rxjava;

/**
 * Created by elevenetc on 21/06/15.
 */
public class ZipObject {
	public SomeObject objectA;
	public SomeObject objectB;

	public ZipObject(SomeObject objectA, SomeObject objectB) {
		this.objectA = objectA;
		this.objectB = objectB;
	}

	@Override public String toString() {
		return "ZipObject{" +
				"objectA=" + objectA +
				", objectB=" + objectB +
				'}';
	}
}
