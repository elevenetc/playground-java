package su.levenetc.algorithms;

/**
 * Created by elevenetc on 12/06/15.
 */
public class Matrices {
	public static int[][] subtract(int[][] a, int[][] b) {
		int rows = a.length;
		int columns = a[0].length;
		int[][] result = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				result[i][j] = a[i][j] - b[i][j];
			}
		}
		return result;
	}

	public static void subtract() {
		int[][] screenMatrix = new int[][]{
				new int[]{0, 0, 0, 0},
				new int[]{0, 2, 2, 2},
				new int[]{0, 2, 1, 2},
				new int[]{0, 2, 2, 2}
		};

		int[][] field = new int[][]{
				new int[]{0, 0, 0, 0},
				new int[]{0, -1, -1, -1},
				new int[]{0, -1, -1, -1},
				new int[]{-1, -1, -1, -1}
		};

		printA((subtract(screenMatrix, field)));
	}

	private static void printA(String name, int[][] array) {
		pln(name + ":");
		printA(array);
	}

	private static void printA(int[][] array) {
		String result = matrixToString(array);
		pln(result);
	}

	private static String matrixToString(int[][] array) {
		StringBuilder builder = new StringBuilder();

		for (int[] rows : array) {
			for (int i : rows) {


				if (i < 10 && i >= 0) {
					builder.append(" " + i);
				} else {
					builder.append(i);
				}

				builder.append(" ");
			}
			builder.append("\n");
		}

		return builder.toString();
	}

	private static void pln(Object result) {
		System.out.println(result.toString());
	}

	private static void pln(String result) {
		System.out.println(result);
	}

	private static void shiftTo(Matrix matrix, int x, int y) {
		if (matrix.shiftX == x && matrix.shiftY == y) return;

		if (x < 0) x = 0;
		if (y < 0) y = 0;

		x = x - matrix.shiftX;
		y = y - matrix.shiftY;

		shift(matrix, x, y);
	}

	private static void shift(Matrix matrix, int x, int y) {
		if (x == 0 && y == 0 || matrix.isEmpty()) return;

		//if data matrix too narrow to be shifted to x then minimize x
		if (x > 0) {
			if (matrix.width < x + matrix.startX + matrix.dataWidth - 1) {
				pln("changed x=" + x);
				x = matrix.width - matrix.dataWidth - matrix.startX + 1;
				pln("to x=" + x);
			}
		} else if (x < 0) {
			if (matrix.startX + x < 0) {
				pln("changed x=" + x);
				x = 0;
				pln("to x=" + x);
			}
		}

		if (y > 0) {
			if (matrix.height < y + matrix.startY + matrix.dataHeight - 1) {
				pln("changed y=" + y);
				y = matrix.height - matrix.dataHeight - matrix.startY + 1;
				pln("to y=" + y);
			}
		} else if (y < 0) {
			if (matrix.startY + y < 0) {
				pln("changed y=" + y);
				y = 0;
				pln("to y=" + y);
			}
		}

		if (x == 0 && y == 0) {
			pln("filled the whole zone to be moved");
			return;
		}

		//check data which corner start to iterating
		if (x >= 0 && y >= 0) {//right bottom corner
			for (int r = matrix.data.length - 1; r >= 0; r--) {
				for (int c = matrix.data[0].length - 1; c >= 0; c--) {
					moveOneElement(matrix.data, r, c, r + y, c + x);
				}
			}
		} else if (x <= 0 && y <= 0) {//left top corner
			for (int r = 0; r < matrix.data.length; r++) {
				for (int c = 0; c < matrix.data[0].length; c++) {
					moveOneElement(matrix.data, r, c, r + y, c + x);
				}
			}
		} else if (x >= 0 && y <= 0) {//right top corner
			for (int r = 0; r < matrix.data.length; r++) {
				for (int c = matrix.data[0].length - 1; c >= 0; c--) {
					moveOneElement(matrix.data, r, c, r + y, c + x);
				}
			}
		} else if (x <= 0 && y >= 0) {//left bottom corner
			for (int r = matrix.data.length - 1; r >= 0; r--) {
				for (int c = 0; c < matrix.data[0].length; c++) {
					moveOneElement(matrix.data, r, c, r + y, c + x);
				}
			}
		}


		matrix.startX = matrix.startX + x;
		matrix.startY = matrix.startY + y;

		matrix.shiftX = matrix.startX;
		matrix.shiftY = matrix.startY;
	}

	private static void moveOneElement(int[][] matrix, int fromRow, int fromCol, int toRow, int toCol) {
		if (matrix[fromRow][fromCol] == 0) return;//needless to move zeros
		if (toRow >= matrix.length || toCol >= matrix[0].length) return;
		matrix[toRow][toCol] = matrix[fromRow][fromCol];
		matrix[fromRow][fromCol] = 0;
	}


	public static void shift() {
		int[][] matrixData = new int[][]{
				new int[]{0, 0, 0, 0},
				new int[]{0, 0, 0, 0},
				new int[]{0, 1, 1, 1},
				new int[]{0, 0, 1, 1}
		};

		Matrix matrix = new Matrix(matrixData);


//		printA("input", matrix.data);
//		shift(matrix, -1, -1);
//		printA("output to 1,1", matrix.data);
//		shift(matrix, -1, -1);
//		printA("output to 1,1", matrix.data);
//		shift(matrix, -1, -1);
//		printA("output to 1,1", matrix.data);

		printA("input", matrix.data);
		shiftTo(matrix, 1, 1);
		printA("output to 1,1", matrix.data);
		shiftTo(matrix, 5, 0);
		printA("output to 0,0", matrix.data);
	}

	private static class Matrix {

		public int shiftY;
		public int shiftX;
		public int width;
		public int height;
		public int dataWidth;
		public int dataHeight;
		public int startX = Integer.MAX_VALUE;
		public int startY = Integer.MAX_VALUE;
		private int[][] data;

		public Matrix(int[][] data) {
			this.data = data;
			initSize();
		}

		private void initSize() {
			int rows = data.length;
			int columns = data[0].length;
			startX = Integer.MAX_VALUE;
			startY = Integer.MAX_VALUE;
			int endX = -1;
			int endY = -1;
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < columns; c++) {
					if (data[r][c] != 0) {

						if (startX > c) {
							startX = c;
						}
						if (c > endX) {
							endX = c;
						}

						if (startY > r) startY = r;
						if (r > endY) endY = r;
					}
				}
			}

			//check if the matrix is not empty
			if (endX != -1 && endY != -1) {
				dataWidth = endX - startX + 1;
				dataHeight = endY - startY + 1;
			}

			shiftX = startX;
			shiftY = startY;
			width = data[0].length - 1;
			height = data.length - 1;
		}

		@Override public String toString() {
			return "dataW:" + dataWidth + " dataH:" + dataHeight + "\n" +
					"w:" + width + " h:" + height + "\n" +
					matrixToString(data);
		}

		public boolean isEmpty() {
			return dataWidth == 0 && dataHeight == 0;
		}
	}
}
