package Matrices;

// LowerTriangularMatrix.java (unchanged, as it was correct)
public class LowerTriangularMatrix {
	private int[] data;
	private int n;           // dimension (n × n matrix)
	
	public LowerTriangularMatrix(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("Matrix size must be positive");
		}
		this.n = n;
		this.data = new int[n * (n + 1) / 2];
	}
	
	// Convert (row,col) → 1D index (row-major, lower triangular)
	private int index(int row, int col) {
		if (col > row) {
			return -1; // zero (not stored)
		}
		// Formula: sum of complete rows above + current row elements
		return row * (row + 1) / 2 + col;
	}
	
	public void set(int row, int col, int value) {
		if (row < 0 || col < 0 || row >= n || col >= n) {
			throw new IndexOutOfBoundsException("Invalid indices");
		}
		if (col > row) {
			if (value != 0) {
				throw new IllegalArgumentException(
						"Cannot set non-zero value above diagonal in lower triangular matrix");
			}
			return;
		}
		data[index(row, col)] = value;
	}
	
	public int get(int row, int col) {
		if (row < 0 || col < 0 || row >= n || col >= n) {
			throw new IndexOutOfBoundsException("Invalid indices");
		}
		if (col > row) {
			return 0;
		}
		return data[index(row, col)];
	}
	
	public int getSize() {
		return n;
	}
	
	public void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%4d ", get(i, j));
			}
			System.out.println();
		}
		System.out.println();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(String.format("%4d ", get(i, j)));
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}