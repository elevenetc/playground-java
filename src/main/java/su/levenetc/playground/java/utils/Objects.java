package su.levenetc.playground.java.utils;

/**
 * Created by levenetc on 13/11/15.
 */
public class Objects {
	public static class A {

		private String id;

		public A() {

		}

		public A(String id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return "A{" +
					"id='" + id + '\'' +
					'}';
		}
	}

	public static class B {

	}

	public static class C {

	}
}
