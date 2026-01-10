package Matrices;

import java.util.*;

/**
 * Simple Sparse Matrix using integers (int)
 * Using Map of Maps (Dictionary of Keys format)
 */
class SparseMatrixInt {
	private final int rows;
	private final int cols;
	// row → (col → value)
	private final Map<Integer, Map<Integer, Integer>> data;
	
	public SparseMatrixInt(int rows, int cols) {
		if (rows <= 0 || cols <= 0) {
			throw new IllegalArgumentException("Matrix dimensions must be positive");
		}
		this.rows = rows;
		this.cols = cols;
		this.data = new HashMap<>();
	}
	
	public int getRows() {
		return rows;
	}
	
	public int getCols() {
		return cols;
	}
	
	/**
	 * Set value at position (row, col)
	 * If value is 0, we remove the entry (true sparse behavior)
	 */
	public void set(int row, int col, int value) {
		validateIndices(row, col);
		
		// Remove entry if value is zero
		if (value == 0) {
			if (data.containsKey(row)) {
				data.get(row).remove(col);
				if (data.get(row).isEmpty()) {
					data.remove(row);
				}
			}
			return;
		}
		
		// Add/update value
		data.computeIfAbsent(row, k -> new HashMap<>()).put(col, value);
	}
	
	/**
	 * Get value at position (row, col)
	 * Returns 0 if no entry exists
	 */
	public int get(int row, int col) {
		validateIndices(row, col);
		return data.getOrDefault(row, Collections.emptyMap()).getOrDefault(col, 0);
	}
	
	private void validateIndices(int row, int col) {
		if (row < 0 || row >= rows) {
			throw new IndexOutOfBoundsException("Row index out of bounds: " + row);
		}
		if (col < 0 || col >= cols) {
			throw new IndexOutOfBoundsException("Column index out of bounds: " + col);
		}
	}
	
	/**
	 * Adds another sparse matrix to this one
	 * Both matrices must have same dimensions
	 */
	public SparseMatrixInt add(SparseMatrixInt other) {
		if (this.rows != other.rows || this.cols != other.cols) {
			throw new IllegalArgumentException("Matrix dimensions must match for addition");
		}
		
		SparseMatrixInt result = new SparseMatrixInt(rows, cols);
		
		// Collect all rows that appear in either matrix
		Set<Integer> allRows = new HashSet<>();
		allRows.addAll(this.data.keySet());
		allRows.addAll(other.data.keySet());
		
		for (int r : allRows) {
			Set<Integer> allCols = new HashSet<>();
			if (this.data.containsKey(r)) {
				allCols.addAll(this.data.get(r).keySet());
			}
			if (other.data.containsKey(r)) {
				allCols.addAll(other.data.get(r).keySet());
			}
			
			for (int c : allCols) {
				int sum = this.get(r, c) + other.get(r, c);
				result.set(r, c, sum);
			}
		}
		
		return result;
	}
	
	/**
	 * Pretty print - shows only non-zero elements with their positions
	 */
	public void printSparse() {
		System.out.println("Sparse Matrix (" + rows + "×" + cols + ") - non-zero elements:");
		if (data.isEmpty()) {
			System.out.println("  (all zeros)");
			return;
		}
		
		// Sort rows and columns for clean output
		List<Integer> sortedRows = new ArrayList<>(data.keySet());
		Collections.sort(sortedRows);
		
		for (int r : sortedRows) {
			Map<Integer, Integer> rowData = data.get(r);
			List<Integer> sortedCols = new ArrayList<>(rowData.keySet());
			Collections.sort(sortedCols);
			
			for (int c : sortedCols) {
				System.out.printf("  (%2d, %2d) → %d%n", r, c, rowData.get(c));
			}
		}
		System.out.println();
	}
	
	/**
	 * Prints complete matrix (good only for small matrices)
	 */
	public void printDense() {
		System.out.println("Dense view (" + rows + "×" + cols + "):");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.printf("%6d ", get(i, j));
			}
			System.out.println();
		}
		System.out.println();
	}
}

// ──────────────────────────────────────────────────────────────

class SparseMatrixIntDemo {
	public static void main(String[] args) {
		// Create two 5×6 sparse matrices
		SparseMatrixInt m1 = new SparseMatrixInt(5, 6);
		SparseMatrixInt m2 = new SparseMatrixInt(5, 6);
		
		// Fill some values (only integers)
		m1.set(0, 1, 45);
		m1.set(0, 4, 20);
		m1.set(2, 0, 70);
		m1.set(2, 5, 35);
		m1.set(4, 3, 90);
		
		m2.set(0, 1, 15);
		m2.set(0, 4, 50);
		m2.set(1, 2, 80);
		m2.set(2, 0, 30);
		m2.set(4, 3, 40);
		
		System.out.println("Matrix 1:");
		m1.printSparse();
		// m1.printDense();  // uncomment if you want to see full matrix
		
		System.out.println("Matrix 2:");
		m2.printSparse();
		
		System.out.println("Result = Matrix1 + Matrix2");
		SparseMatrixInt sum = m1.add(m2);
		
		sum.printSparse();
		sum.printDense();
	}
}