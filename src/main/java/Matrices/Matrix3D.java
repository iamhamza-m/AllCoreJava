package Matrices;

public class Matrix3D {
	public static void print3D(int[][][] arr) {
		if (arr == null || arr.length == 0) {
			System.out.println("Empty 3D array");
			return;
		}
		
		int depth = arr.length;
		int rows  = arr[0].length;
		int cols  = arr[0][0].length;
		
		System.out.println("3D Matrix [" + depth + "][" + rows + "][" + cols + "]:");
		System.out.println("----------------------------------------");
		
		for (int k = 0; k < depth; k++) {
			System.out.println("Layer " + k + ":");
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					System.out.printf("%4d ", arr[k][i][j]);
				}
				System.out.println();
			}
			System.out.println(); // empty line between layers
		}
		System.out.println("----------------------------------------");
	}
	
	public static void main(String[] args) {
		int[][][] matrix = {
				{   // Layer 0
						{1,  2,  3},
						{4,  5,  6},
						{7,  8,  9}
				},
				{   // Layer 1
						{10, 11, 12},
						{13, 14, 15},
						{16, 17, 18}
				},
				{   // Layer 2
						{19, 20, 21},
						{22, 23, 24},
						{25, 26, 27}
				}
		};
		
		print3D(matrix);
		
	}
}
