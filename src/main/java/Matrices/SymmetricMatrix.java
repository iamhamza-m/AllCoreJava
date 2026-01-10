package Matrices;

/**
 * Represents a symmetric square matrix (A[i][j] == A[j][i])
 * Stores only the upper triangle (including diagonal) to save space
 */
public class SymmetricMatrix {
	private final int n;
	private final int[] data;  // stores upper triangle row-major
	
	public SymmetricMatrix(int size) {
		if (size <= 0) throw new IllegalArgumentException("Size must be positive");
		this.n = size;
		// Number of elements: n + (n-1) + ... + 1 = n*(n+1)/2
		this.data = new int[n * (n + 1) / 2];
	}
	
	private int index(int i, int j) {
		// We always store the upper triangle (i <= j)
		if (i > j) {
			int temp = i;
			i = j;
			j = temp;
		}
		// row-major indexing for upper triangle
		return i * (2 * n - i + 1) / 2 + (j - i);
	}
	
	public void set(int i, int j, int value) {
		checkBounds(i, j);
		data[index(i, j)] = value;
		// No need to set symmetric counterpart - we use the same location
	}
	
	public int get(int i, int j) {
		checkBounds(i, j);
		return data[index(i, j)];
	}
	
	public int size() {
		return n;
	}
	
	private void checkBounds(int i, int j) {
		if (i < 0 || i >= n || j < 0 || j >= n) {
			throw new IndexOutOfBoundsException(
					String.format("Indices out of bounds: (%d, %d)  size=%d", i, j, n));
		}
	}
	
	public void printMatrix() {
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
