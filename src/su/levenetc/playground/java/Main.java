package su.levenetc.playground.java;


import su.levenetc.playground.java.utils.Out;

public class Main {

	public static void main(String[] args) throws InterruptedException {
//		FindIntersection.run();
		RectF rectA = new RectF(100, 100, 200, 200);
		float centerX = rectA.centerX();
		float centerY = rectA.centerY();
		Out.pln(centerX + ":" + centerY);

		double deg = 10;


	}
}