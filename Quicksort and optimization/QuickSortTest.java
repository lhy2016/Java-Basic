package sjsu.Liu.cs146.project2;

public class QuickSortTest 
{
	public static void main(String [] args)
	{
		Quicksort QS = new Quicksort();
		int [] A = Quicksort.createRandomArr(10000);  // TODO: Just change array size here to test each quicksort algorithm.
		int [] B = new int [A.length];
		int [] C = new int [A.length];
		for(int i = 0;i<A.length;i++)   // makes two other copies to provide identical input array
		{
			B[i] = A[i];
			C[i] = A[i];
		}
		System.out.println("Input array size: "+A.length+"\n");
        System.out.println("Testing quickSort1(using last item as the pivot):");
		QS.reset();
		long time1 = System.currentTimeMillis();
		QS.quickSort1(A,0,A.length-1);
		long duration1 = System.currentTimeMillis()-time1;
		System.out.println("# of comparisons: "+QS.get_counter_lastPivot());
		System.out.println("Time: "+duration1+"ms");
		QS.reset();
		
		System.out.println("\nTesting quickSort2(using median as the pivot by using randomized selection algorithm):");
		long time2 = System.currentTimeMillis();
		QS.quickSort2(B,0,B.length-1);
		long duration2 = System.currentTimeMillis()-time2;
		System.out.println("# of comparisons: "+QS.get_counter_randomized());
		System.out.println("Time: "+duration2+"ms");
		QS.reset();
		
		System.out.println("\nTesting quickSort3(using median as the pivot by using deterministic selection algorithm):");
		int [][] temp = QS.convert_1D_to_Hash(C, 0, C.length-1);
		long time3 = System.currentTimeMillis();
		QS.quickSort3(temp,0,C.length-1);
		long duration3 = System.currentTimeMillis()-time3;
		System.out.println("# of comparisons: "+QS.get_counter_medianOfMedians());
		System.out.println("Time: "+duration3+"ms");
		QS.reset();
	
		
	
	}
}
