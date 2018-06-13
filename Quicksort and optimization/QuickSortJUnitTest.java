package sjsu.Liu.cs146.project2;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Before; 
import org.junit.Test;

public class QuickSortJUnitTest 
{
	  private Quicksort QS;
	   @Before    
	   public void setUp() throws Exception    
	   {       
		   QS = new Quicksort();       
		   QS.reset();    
	   } 
	   
	   /* Method to test the Sorting of an empty List
	    */
	   @Test
	   public void testEmpty() 
	   {
	             int[] array1 = new int[0];
	             int[]  array2= new int[0]; //correct sorted array
	             
	             QS.quickSort1(array1, 0, array1.length - 1);
	             assertArrayEquals(array1,array2);
	             QS.quickSort2(array1, 0, array1.length - 1);
	             assertArrayEquals(array1,array2);
	             
	             int [][] arr1 = QS.convert_1D_to_Hash(array1, 0, array1.length-1); // set up for ONLY quickSort 3;
	             int [][] arr2 = QS.convert_1D_to_Hash(array2, 0, array2.length-1);
	             QS.quickSort3(arr1, 0, array1.length - 1);
	             assertArrayEquals(arr1,arr2);
	   }   
	   
	   /* Method to test the Sorting of an already sorted list:
	    */
	   @Test
	   public void testSorted() 
	   {
	     int[] array1 = new int[20];
	     int[] array2 = new int[20];
	 	 int[] array3 = new int[20]; // correct sorted array
	 	 int [] array4 = new int[20];
	              
		 for (int i = 0; i < 20; i++) 
		 {
			 
	         array1[i] = i*2;
	         array2[i] = i*2;
		     array3[i] = i*2;
		     array4[i] = i*2;

	      }
		// sort using Java's inbuilt sorting method, should remain unchanged.
	        Arrays.sort(array3);
	         
	        // run QS1()
	        QS.quickSort1(array1, 0, array1.length - 1);
	        assertArrayEquals(array1,array3);
	        
	        // run QS2()
	        QS.quickSort2(array2, 0, array2.length - 1);
	        assertArrayEquals(array2,array3);
	        // run QS3()
	        int [][] arr4 = QS.convert_1D_to_Hash(array4, 0, array4.length-1); // set up for ONLY quickSort 3;
            int [][] arr3 = QS.convert_1D_to_Hash(array3, 0, array3.length-1);
            QS.quickSort3(arr4, 0, array4.length - 1);
            assertArrayEquals(arr4[1],array3);
            }
	   

	   /* Method to test the Sorting of a reverse sorted list:
	    */
	   @Test
	   public void testReverseSorted() {
	        int[] array1 = new int[10];
	        int[] array2 = new int[10];
	        int[] array4 = new int[10];
	        
	        int[] array3 = new int[10];// correct sorted array
	        
	        for (int i = 0; i < 10; i++) 
	        {
	             array1[i] = (10-i);
	             array2[i] = (10-i);
	             array3[i] = (10-i);
	             array4[i] = (10-i);
	        }
	        //sort array3 
	        Arrays.sort(array3); 
	   
	        // run QS1()
	        QS.quickSort1(array1, 0, array1.length - 1);
	        assertArrayEquals(array1,array3);
	        
	        // run QS2()
	        QS.quickSort2(array2, 0, array2.length - 1);
	        assertArrayEquals(array1,array3);
	        // run QS3()
	        int [][] arr4 = QS.convert_1D_to_Hash(array4, 0, array4.length-1); // set up for ONLY quickSort 3;
           
	        QS.quickSort3(arr4, 0, array4.length-1);
            assertArrayEquals(arr4[1],array3);
	        
	   }
	   
	   /*
	    * Method to test the randomness to the tests:
	    */
	    @Test
	     public void testRandom() {
	       int[] array1 = new int[10];
	       
	       for (int i = 0; i < 10; i++) {
	            array1[i] = (int) Math.random()*10;
	       } 
	 
	       //copy arrays
	       int[] array2 = Arrays.copyOf(array1, array1.length);  
	       int[] array4 = Arrays.copyOf(array1, array1.length);
	       int[] array3 = Arrays.copyOf(array1, array1.length); // correct sorted array 
	       Arrays.sort(array3);
	 
	       // run QS1()
	       QS.quickSort1(array1, 0, array1.length - 1);
	       assertArrayEquals(array1,array3);
	       
	       // run QS2()
	       QS.quickSort2(array2, 0, array2.length - 1);
	       assertArrayEquals(array1,array3);
	       
	       // run QS3()
	        int [][] arr4 = QS.convert_1D_to_Hash(array4, 0, array4.length-1); // set up for ONLY quickSort 3;
          
	        QS.quickSort3(arr4, 0, array4.length-1);
           assertArrayEquals(arr4[1],array3);
	       
	     }
	    
	    /* Method to test the timing of QS1
	    *
	    */
	   @Test
	   public void testQS1Timing()
	   {
	      // create an array and a sorted backup
	      int[] array1 = Quicksort.createRandomArr(10000);
	      int[] array2 = Quicksort.createRandomArr(1000000);
	      int[] array3 = Quicksort.createRandomArr(100000000);
	      
	      
	      long start = System.currentTimeMillis();
	      QS.quickSort1(array1, 0, array1.length - 1);
	      long end = System.currentTimeMillis();
	      long elapsed = end - start;
	      System.out.println("QS1 time to sort 10000 elements in ms:"+ elapsed);

	      start = System.currentTimeMillis();
	      QS.quickSort1(array2, 0, array2.length - 1);
	      end = System.currentTimeMillis();
	      elapsed = end - start;
	      System.out.println("QS1 time to sort 1000000 elements in ms:"+ elapsed);
	      
	      start = System.currentTimeMillis();
	      QS.quickSort1(array3, 0, array3.length - 1);
	      end = System.currentTimeMillis();
	      elapsed = end - start;
	      System.out.println("QS1 time to sort 100000000 elements in ms:"+ elapsed);
	   }
	   /* Method to test the timing of QS2
	    *
	    */
	   @Test
	   public void testQS2Timing()
	   {
	      // create an array and a sorted backup
	      int[] array1 = Quicksort.createRandomArr(10000);
	      int[] array2 = Quicksort.createRandomArr(1000000);
	      int[] array3 = Quicksort.createRandomArr(100000000);
	      
	      
	      long start = System.currentTimeMillis();
	      QS.quickSort2(array1, 0, array1.length - 1);
	      long end = System.currentTimeMillis();
	      long elapsed = end - start;
	      System.out.println("QS2 time to sort 10000 elements in ms:"+ elapsed);

	      start = System.currentTimeMillis();
	      QS.quickSort2(array2, 0, array2.length - 1);
	      end = System.currentTimeMillis();
	      elapsed = end - start;
	      System.out.println("QS2 time to sort 1000000 elements in ms:"+ elapsed);
	      
	      start = System.currentTimeMillis();
	      QS.quickSort2(array3, 0, array3.length - 1);
	      end = System.currentTimeMillis();
	      elapsed = end - start;
	      System.out.println("QS2 time to sort 100000000 elements in ms:"+ elapsed);
	   } 
	   
	   /*
	    * Method to test the number of comparisons in sorting an already sorted array of 10 numbers.
	    * Number of comparisons should be 45
	    */
	   @Test
	   public void testgetPartCount()
	   {
	      int[] array1 = new int[10];
	      
	    //  int[] result1 = new int[10];
	      
	      for (int i = 0; i < 10; i++) {
	           array1[i] = i*20;
	      }
	      QS.reset();
	      QS.quickSort1(array1, 0, array1.length - 1);
	      System.out.println("comparisons in already sorted:"+ QS.get_counter_lastPivot());
	      long compare=(long)QS.get_counter_lastPivot();
	      assertEquals(compare, 45);
	   }
	   
	   /*
	    * Method to test the number of comparisons in reverse sorted array of 10 numbers.
	    * Number of comparisons should be 45.
	    */	
	   @Test
	   public void testgetPartCountA()
	   {
	      int[] array1 = new int[10];
	      
	      for (int i = 0; i < 10; i++) {
	           array1[i] = (100-i);
	      }
	      
	      QS.quickSort1(array1, 0, array1.length - 1);
	      System.out.println("comparisons in reverse sorted:"+ QS.get_counter_lastPivot());
	      long compare=(long)QS.get_counter_lastPivot();
	      assertEquals(compare, 45);
	         
	   } // getPartCount()
	   




}
