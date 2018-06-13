import java.util.Random;
import java.util.Scanner;

public class MatrixMultiplicationTest 
{
	public static Scanner scanner = new Scanner(System.in);
	private static int userInput = 0;

	public static void main(String[] args) 
	{
		do
		{
			System.out.println("Please enter the size of matrix (must be power of 2):");
			userInput = scanner.nextInt();
		}
		while(!Matrix.isPowerOf2(userInput));
		
		int [][] a = new int [userInput][userInput];
		int [][] b = new int [userInput][userInput];
		generateRandomMatrix(a);
		generateRandomMatrix(b);
		
		Matrix m1 = new Matrix(a);
		Matrix m2 = new Matrix(b);
		
		final long time1 = System.nanoTime();
		Matrix productRegular = m1.productRegular(m2);
		final long duration1 = System.nanoTime() - time1;
		final long time2 = System.nanoTime();
		Matrix productStrassen = m1.productStrassen(m2);
		final long duration2 = System.nanoTime()-time2;
		
		System.out.println("Matrix 1:");
		m1.printMatrix();
		System.out.println("\nMatrix 2:");
		m2.printMatrix();
		System.out.println("\nRegular product:");
		productRegular.printMatrix();
		System.out.println("\nRunning time: "+(duration1)+" ns");
		System.out.println("\nStrassen product:");
		productStrassen.printMatrix();
		System.out.println("\nRunning time:" +(duration2)+" ns");

	}
	
	public static void generateRandomMatrix(int [][] m)
	{
		Random rand = new Random();
		for(int i = 0;i<m.length;i++)
		{
			for (int j = 0;j<m[i].length;j++)
			{
				m[i][j] = rand.nextInt(10);
			}
		}
	}
	

}
