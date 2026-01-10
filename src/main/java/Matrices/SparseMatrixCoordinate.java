package Matrices;

import java.util.*;

/**
 * Sparse Matrix using COO (Coordinate List) format
 * Stores only non-zero elements with their row and column indices
 */
class SparseMatrixCOO {
	private final int rows;
	private final int cols;
	
	// Three parallel lists (COO format)
	private final List<Integer> rowIndices;
	private final List<Integer> colIndices;
	private final List<Integer> values;
	
	public SparseMatrixCOO(int rows, int cols) {
		if (rows <= 0 || cols <= 0) {
			throw new IllegalArgumentException("Matrix dimensions must be positive");
		}
		this.rows = rows;
		this.cols = cols;
		this.rowIndices = new ArrayList<>();
		this.colIndices = new ArrayList<>();
		this.values = new ArrayList<>();
	}
	
	public int getRows() {
		return rows;
	}
	
	public int getCols() {
		return cols;
	}
	
	/**
	 * Set value at position (row, col)
	 * If value is 0 → we remove the entry if it existed
	 */
	public void set(int row, int col, int value) {
		validateIndices(row, col);
		
		// Find if position already exists
		for (int i = 0; i < rowIndices.size(); i++) {
			if (rowIndices.get(i) == row && colIndices.get(i) == col) {
				if (value == 0) {
					// Remove entry
					rowIndices.remove(i);
					colIndices.remove(i);
					values.remove(i);
				} else {
					// Update value
					values.set(i, value);
				}
				return;
			}
		}
		
		// New non-zero entry
		if (value != 0) {
			rowIndices.add(row);
			colIndices.add(col);
			values.add(value);
		}
	}
	
	/**
	 * Get value at (row, col)
	 * Returns 0 if position doesn't exist
	 */
	public int get(int row, int col) {
		validateIndices(row, col);
		
		for (int i = 0; i < rowIndices.size(); i++) {
			if (rowIndices.get(i) == row && colIndices.get(i) == col) {
				return values.get(i);
			}
		}
		return 0;
	}
	
	private void validateIndices(int row, int col) {
		if (row < 0 || row >= rows) throw new IndexOutOfBoundsException("Invalid row: " + row);
		if (col < 0 || col >= cols) throw new IndexOutOfBoundsException("Invalid col: " + col);
	}
	
	/**
	 * Add two COO sparse matrices (same dimensions required)
	 */
	public SparseMatrixCOO add(SparseMatrixCOO other) {
		if (this.rows != other.rows || this.cols != other.cols) {
			throw new IllegalArgumentException("Matrices must have same dimensions for addition");
		}
		
		SparseMatrixCOO result = new SparseMatrixCOO(rows, cols);
		
		// Collect all possible (row,col) positions from both matrices
		Set<String> allPositions = new HashSet<>();
		for (int i = 0; i < this.rowIndices.size(); i++) {
			allPositions.add(this.rowIndices.get(i) + "," + this.colIndices.get(i));
		}
		for (int i = 0; i < other.rowIndices.size(); i++) {
			allPositions.add(other.rowIndices.get(i) + "," + other.colIndices.get(i));
		}
		
		for (String pos : allPositions) {
			String[] parts = pos.split(",");
			int r = Integer.parseInt(parts[0]);
			int c = Integer.parseInt(parts[1]);
			
			int sum = this.get(r, c) + other.get(r, c);
			if (sum != 0) {
				result.set(r, c, sum);
			}
		}
		
		return result;
	}
	
	/**
	 * Print non-zero elements in COO style
	 */
	public void printCOO() {
		System.out.println("COO Sparse Matrix (" + rows + "×" + cols + ") - " + values.size() + " non-zero elements:");
		if (values.isEmpty()) {
			System.out.println("  (completely zero matrix)");
			return;
		}
		
		System.out.println("  row  col  value");
		System.out.println("  -----------------");
		
		// We sort for nicer output (optional - real COO doesn't need to be sorted)
		List<Integer> indices = new ArrayList<>();
		for (int i = 0; i < values.size(); i++) indices.add(i);
		
		indices.sort(Comparator.comparing(rowIndices::get)
							 .thenComparing(colIndices::get));
		
		for (int idx : indices) {
			System.out.printf("  %3d  %3d   %d%n",
					rowIndices.get(idx),
					colIndices.get(idx),
					values.get(idx));
		}
		System.out.println();
	}
	
	/**
	 * Print as dense matrix (only good for small matrices!)
	 */
	public void printDense() {
		System.out.println("Dense view (" + rows + "×" + cols + "):");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.printf("%5d ", get(i, j));
			}
			System.out.println();
		}
		System.out.println();
	}
}

// ──────────────────────────────────────────────────────────────

class SparseMatrixCOODemo {
	public static void main(String[] args) {
		SparseMatrixCOO m1 = new SparseMatrixCOO(6, 7);
		SparseMatrixCOO m2 = new SparseMatrixCOO(6, 7);
		
		// Some example values
		m1.set(0, 2, 15);
		m1.set(1, 5, 8);
		m1.set(3, 1, 42);
		m1.set(5, 4, 7);
		
		m2.set(0, 2, 5);
		m2.set(1, 5, 12);
		m2.set(3, 1, 20);
		m2.set(4, 3, 30);
		m2.set(5, 4, 3);
		
		System.out.println("Matrix 1:");
		m1.printCOO();
		
		System.out.println("Matrix 2:");
		m2.printCOO();
		
		System.out.println("Result = M1 + M2");
		SparseMatrixCOO sum = m1.add(m2);
		sum.printCOO();
		sum.printDense();   // uncomment for full matrix view
	}
}