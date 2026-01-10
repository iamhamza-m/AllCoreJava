package Matrices;

public class DiagonalMatrix {
	static void main(String[] args) {
		
		/*
		 * Problem to be addressed.
		 * Storing zeros in rest of the indices is wastage of memory.
		 * */
		int[][] Matrix = new int[5][5];
		for(int i = 0; i < Matrix.length; i++){
			for(int j=0; j < Matrix[i].length; j++){
				if(i == j){
					Matrix[i][j] = i+1;
				}else{
					Matrix[i][j] = 0;
				}
			}
		}
		
		for(int i = 0; i < Matrix.length; i++){
			for(int j=0; j < Matrix[i].length; j++){
				System.out.printf("%d ",Matrix[i][j]);
			}
			System.out.println();
		}
		
		/*
		* The same content can also be stored as a single dimensional array.
		* */
		
		int[] diagMatrix = new int[5];
		
		for(int i = 0; i < Matrix.length; i++){
			for(int j=0; j < Matrix[i].length; j++) {
				if (i == j) {
					diagMatrix[i] = Matrix[i][j];
				}
			}
		}
		System.out.println("Diagonal matrix");
		for(int num : diagMatrix){
			System.out.printf("%d ",num);
		}
	}
}
