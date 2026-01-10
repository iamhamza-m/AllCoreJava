package Matrices;

// UpperTriangularMatrix.java
public class UpperTriangularMatrix {
	private int[] data;
	private int n;           // dimension (n × n matrix)
	
	// Constructor - creates n×n upper triangular matrix
	public UpperTriangularMatrix(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("Matrix size must be positive");
		}
		this.n = n;
		// Number of elements = n(n+1)/2
		this.data = new int[n * (n + 1) / 2];
	}
	
	// Convert (row,col) → 1D index (row-major, upper triangular)
	private int index(int row, int col) {
		// Only elements where row <= col are stored
		if (row > col) {
			return -1; // represents zero (not stored)
		}
		// Correct formula: row * n - (row * (row - 1) / 2) + (col - row)
		return row * n - (row * (row - 1) / 2) + (col - row);
	}
	
	public void set(int row, int col, int value) {
		if (row < 0 || col < 0 || row >= n || col >= n) {
			throw new IndexOutOfBoundsException("Invalid indices");
		}
		if (row > col) {
			if (value != 0) {
				throw new IllegalArgumentException(
						"Cannot set non-zero value below diagonal in upper triangular matrix");
			}
			return; // ignore zeros below diagonal
		}
		data[index(row, col)] = value;
	}
	
	public int get(int row, int col) {
		if (row < 0 || col < 0 || row >= n || col >= n) {
			throw new IndexOutOfBoundsException("Invalid indices");
		}
		if (row > col) {
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
