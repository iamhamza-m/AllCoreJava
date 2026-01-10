package Matrices;

public class LowerTriangleMatrix {
	static void main(String[] args) {
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
		
	}
}
