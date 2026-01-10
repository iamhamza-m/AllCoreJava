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
		
		
		System.out.println("=== SYMMETRIC MATRIX ===\n");
		SymmetricMatrix sym = new SymmetricMatrix(5);
		sym.set(0,0, 5);
		sym.set(0,1, 2);
		sym.set(0,2, 7);
		sym.set(0,3, 3);
		sym.set(0,4, 6);
		sym.set(1,1, 3);
		sym.set(1,2, 9);
		sym.set(1,3, 1);
		sym.set(1,4, 8);
		sym.set(2,2, 2);
		sym.set(2,3, 4);
		sym.set(2,4, 5);
		sym.set(3,3, 1);
		sym.set(3,4, 9);
		sym.set(4,4, 10);
		
		sym.printMatrix();
		
		System.out.println("=== TRIDIAGONAL MATRIX ===\n");
		TridiagonalMatrix tri = new TridiagonalMatrix(5);
		for (int i = 0; i < 5; i++) tri.set(i,i, 10);
		for (int i = 0; i < 4; i++) {
			tri.set(i,i+1, 11);
			tri.set(i+1,i, 9);
		}
		
		tri.printMatrix();
		
		
		System.out.println("=== TOEPLITZ MATRIX ===\n");
		ToeplitzMatrix toe = new ToeplitzMatrix(5);
		int[] diagtoe = {10, 1, 2, 3, 4};
		for (int i = 0; i < 5; i++) {
			toe.setFirstRow(i, diagtoe[i]);
			toe.setFirstColumn(i, diagtoe[i]);
		}
		
		toe.printMatrix();
		
		
	}
}