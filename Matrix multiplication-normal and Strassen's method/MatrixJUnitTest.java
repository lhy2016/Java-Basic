import static org.junit.Assert.assertArrayEquals; 
import junit.framework.TestCase;
import org.junit.Before; 
import org.junit.Test;

public class MatrixJUnitTest extends TestCase
{
	private Matrix A, B; 
	private Matrix productRegularResult;
    private Matrix productStrassenResult;
	private int N;
	
	@Before public void setUp() throws Exception 
	{    
		N = 4; // size of the matrix    
		int [][] array1 = new int [N][N];    
		int[][] array2 = new int[N][N];  
		MatrixMultiplicationTest.generateRandomMatrix(array1);
		A = new Matrix(array1);   
		MatrixMultiplicationTest.generateRandomMatrix(array2);
		B = new Matrix(array2);    
		
	}
	@Test
	public void testProductCompare()
	{
		// run productRegular()      
		productRegularResult = A.productRegular(B);           
		// run productStrassen()
		productStrassenResult = A.productStrassen(B);
	    for(int i = 0;i<N;i++)
	    {
	    	assertArrayEquals(productRegularResult.getMatrix()[i],
	    			productStrassenResult.getMatrix()[i]);
	    }
	}
	@Test
	public void testProductRegular()
	{
		int[][] expected = {{96,94,81,128},
				{144,117,112,162},{132,112,101,152},{112,86,87,130}};
		int[][] array1 = {{2,4,5,7},{6,7,2,8},
				{4,6,3,9},{8,4,1,5}};
		int[][] array2 = {{6,4,5,8},{8,7,8,8},
				{2,6,5,9},{6,4,2,5}};
		
		Matrix m1 = new Matrix(array1); 
		Matrix m2 = new Matrix(array2);
		productRegularResult = m1.productRegular(m2);
		 for (int i = 0; i < N; i++) 
		 {
			 assertArrayEquals(productRegularResult.getMatrix()[i],
		    			expected[i]);
		 }
		 
	}
	
	@Test 
	public void testProductStrassen() 
	{
		int[][] expected = {{96,94,81,128},
				{144,117,112,162},{132,112,101,152},{112,86,87,130}};
		int[][] array1 = {{2,4,5,7},{6,7,2,8},
				{4,6,3,9},{8,4,1,5}};
		int[][] array2 = {{6,4,5,8},{8,7,8,8},
				{2,6,5,9},{6,4,2,5}};
		
		Matrix m1 = new Matrix(array1); 
		Matrix m2 = new Matrix(array2);
		productStrassenResult = m1.productStrassen(m2);
		 for (int i = 0; i < N; i++) 
		 {
			 assertArrayEquals(productStrassenResult.getMatrix()[i],
		    			expected[i]);
		 }
		
	}
	
}
