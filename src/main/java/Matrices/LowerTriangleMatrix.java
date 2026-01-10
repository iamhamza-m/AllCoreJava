package Matrices;

public class LowerTriangleMatrix {
	static void main(String[] args) {
		
		/*
		 * Problem to be addressed.
		 * Storing zeros in rest of the indices is wastage of memory.
		 * */
		int[][] lowerTrigMatrix = new int[5][5];
		for(int i=0; i < lowerTrigMatrix.length; i++){
			for(int j=0; j < lowerTrigMatrix[i].length; j++){
				if(i >= j)
					lowerTrigMatrix[i][j] = i+1;
			}
		}
		
		for (int[] trigMatrix : lowerTrigMatrix) {
			for (int matrix : trigMatrix) {
				System.out.printf("%d ", matrix);
			}
			System.out.println();
		}
		
		/*
		 * The same content can also be stored as a single dimensional array.
		 * Required array length = n^2 - n(n+1)/2 = n(n-1)/2
		 * Formula to fetch -> A[i][j] = i(i+1)/2 + j - i;
		 * */
		
		
		
		
	}
}
