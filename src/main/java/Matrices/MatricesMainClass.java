package Matrices;

public class MatricesMainClass {
	public static void main(String[] args) {
		System.out.println("=== UPPER TRIANGULAR MATRIX ===\n");
		UpperTriangularMatrix upper = new UpperTriangularMatrix(5);
		
		upper.set(0, 0, 10);
		upper.set(0, 1, 11);
		upper.set(0, 2, 12);
		upper.set(0, 3, 13);
		upper.set(0, 4, 14);
		upper.set(1, 1, 21);
		upper.set(1, 2, 22);
		upper.set(1, 3, 23);
		upper.set(1, 4, 24);
		upper.set(2, 2, 32);
		upper.set(2, 3, 33);
		upper.set(2, 4, 34);
		upper.set(3, 3, 43);
		upper.set(3, 4, 44);
		upper.set(4, 4, 55);
		
		upper.print();
		
		System.out.println("=== LOWER TRIANGULAR MATRIX ===\n");
		LowerTriangularMatrix lower = new LowerTriangularMatrix(5);
		
		lower.set(0, 0, 10);
		lower.set(1, 0, 20);
		lower.set(1, 1, 21);
		lower.set(2, 0, 30);
		lower.set(2, 1, 40);
		lower.set(2, 2, 45);
		lower.set(3, 0, 50);
		lower.set(3, 1, 55);
		lower.set(3, 2, 60);
		lower.set(3, 3, 61);
		lower.set(4, 0, 99);
		lower.set(4, 1, 99);
		lower.set(4, 2, 99);
		lower.set(4, 3, 99);
		lower.set(4, 4, 99);
		
		lower.print();
		
		System.out.println("=== DIAGONAL MATRIX ===\n");
		
		DiagonalMatrix diag = new DiagonalMatrix(5);
		
		diag.set(0, 0, 7);
		diag.set(1, 1, 89);
		diag.set(2, 2, 11);
		diag.set(3, 3, 34);
		diag.set(4, 4, 42);
		
		diag.print();
	}
}