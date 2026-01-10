package Matrices;

/**
 * General Toeplitz matrix (not necessarily symmetric)
 * Each descending diagonal is constant.
 * Stores first row and first column (excluding shared [0][0]).
 */
public class ToeplitzMatrix {
	private final int rows;
	private final int cols;
	private final int[] firstRow;  // length = cols
	private final int[] firstCol;  // length = rows, firstCol[0] is unused
	
	public ToeplitzMatrix(int rows, int cols) {
		if (rows <= 0 || cols <= 0) throw new IllegalArgumentException("Dimensions must be positive");
		this.rows = rows;
		this.cols = cols;
		this.firstRow = new int[cols];
		this.firstCol = new int[rows]; // index 0 unused
	}
	
	/**
	 * Square Toeplitz matrix constructor
	 */
	public ToeplitzMatrix(int size) {
		this(size, size);
	}
	
	public void setFirstRow(int j, int value) {
		if (j < 0 || j >= cols) throw new IndexOutOfBoundsException("Column index out of bounds");
		firstRow[j] = value;
	}
	
	public void setFirstColumn(int i, int value) {
		if (i < 0 || i >= rows) throw new IndexOutOfBoundsException("Row index out of bounds");
		firstCol[i] = value;
	}
	
	public int get(int i, int j) {
		if (i < 0 || i >= rows || j < 0 || j >= cols) {
			throw new IndexOutOfBoundsException(
					String.format("Index out of bounds: (%d,%d)  size=%dx%d", i, j, rows, cols));
		}
		
		int diff = j - i;
		
		if (diff >= 0) {
			// superdiagonal or diagonal → use first row
			return firstRow[diff];
		} else {
			// subdiagonal → use first column
			return firstCol[-diff];
		}
	}
	
	public void printMatrix() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.printf("%4d ", get(i, j));
			}
			System.out.println();
		}
		System.out.println();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				sb.append(String.format("%4d ", get(i, j)));
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	// Convenience: create symmetric Toeplitz from one array
	public static ToeplitzMatrix symmetricFromArray(int... values) {
		if (values == null || values.length == 0) throw new IllegalArgumentException();
		int n = values.length;
		ToeplitzMatrix m = new ToeplitzMatrix(n);
		for (int k = 0; k < n; k++) {
			m.setFirstRow(k, values[k]);
			m.setFirstColumn(k, values[k]); // mirror
		}
		return m;
	}
}