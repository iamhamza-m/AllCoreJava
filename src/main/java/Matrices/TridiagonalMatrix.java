package Matrices;

/**
 * Tridiagonal matrix - only main diagonal, subdiagonal and superdiagonal are stored
 */
public class TridiagonalMatrix {
	private final int n;
	private final int[] main;     // diagonal (size n)
	private final int[] upper;    // superdiagonal (size n-1)
	private final int[] lower;    // subdiagonal (size n-1)
	
	public TridiagonalMatrix(int size) {
		if (size <= 0) throw new IllegalArgumentException("Size must be positive");
		this.n = size;
		this.main = new int[n];
		this.upper = new int[n - 1];
		this.lower = new int[n - 1];
	}
	
	public void set(int i, int j, int value) {
		checkBounds(i, j);
		
		int diff = j - i;
		if (diff == 0) {
			main[i] = value;
		} else if (diff == 1) {
			upper[i] = value;
		} else if (diff == -1) {
			lower[j] = value;  // j = i-1 → lower[i-1]
		} else {
			throw new IllegalArgumentException(
					"Can only set elements on main, sub or super diagonal");
		}
	}
	
	public int get(int i, int j) {
		checkBounds(i, j);
		
		int diff = j - i;
		if (diff == 0) return main[i];
		if (diff == 1) return upper[i];
		if (diff == -1) return lower[j];
		return 0;
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
				System.out.printf("%6d ", get(i, j));
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
