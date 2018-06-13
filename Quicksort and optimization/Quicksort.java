package sjsu.Liu.cs146.project2;

import java.util.Random;

public class Quicksort 
{
	private float counter_lastPivot, counter_randomized,counter_medianOfMedians = 0;
	private static Random rand = new Random();
	
	public float get_counter_lastPivot(){return counter_lastPivot;}
	public float get_counter_randomized(){return counter_randomized;}
	public float get_counter_medianOfMedians(){return counter_medianOfMedians;}
	
	
	public void reset()
	{
		counter_lastPivot = 0; 
		counter_randomized = 0;
		counter_medianOfMedians = 0;
	}
	
	public static int [] createRandomArr(int size)
	{
		int [] arr = new int [size];
		for(int i = 0;i<size;i++)
		{
			arr[i]=rand.nextInt(size+1);
		}
		return arr;
	}
	
	public void quickSort1(int [] A, int p, int r)  // last item as the pivot.
	{
		
		if(p<r)
		{
			int q = partition_last(A, p, r);
			quickSort1(A, p, q-1);
			quickSort1(A,q+1,r);
		}
	}
	
	public void quickSort2(int [] A, int p, int r) // select median as the pivot(using randomized selection algorithm)
	{
		
		if(p<r)
		{
			int order_stat = (r-p)/2;
			int q = partition_median(A,p,r,order_stat);
			
			quickSort2(A,p,q-1);
			quickSort2(A,q+1,r);
		}
		
	}
	
	public void quickSort3(int [][] A,int p, int r)  // select median as the pivot(using median of the medians(deterministic) algorithm)
	{
		if(p<r)
		{
			int q = selection_medianOfMedians(A,p,r);
			swap(A[0],r,q);
			swap(A[1],r,q);
			int mid = partition(A,p,r);
			quickSort3(A, p, mid-1);
			quickSort3(A,mid+1,r);
		}
	}
	
	
	private int partition_last(int [] A, int p, int r) //partition method that choose the last item as the pivot.
	{
		int x = A[r];  //select last item as the pivot
		int i = p-1;
		for(int j = p; j<r;j++)
		{
			counter_lastPivot++;
			counter_randomized++;
			if(A[j] <= x)
			{
				i++;
				swap(A, i, j);
			}
			
		}
		swap(A, i+1, r);
		return i+1;	
	}
	
	private int partition(int [][] A,int p,int r) //customized partition method ONLY for QuickSort3
	{
		int x = A[1][r];  //select last item as the pivot
		int i = p-1;
		for(int j = p; j<r;j++)
		{
			counter_medianOfMedians++;
			if(A[1][j] <= x)
			{
				i++;
				swap(A[1], i, j);
				swap(A[0],i,j);
			}
			
		}
		swap(A[0], i+1, r);
		swap(A[1],i+1,r);
		return i+1;	
	}
	
	private int partition_median(int [] A,int p,int r, int order_stat)
	{
		int i = (int)rand.nextInt((r - p) + 1) + p; //randomly select a pivot
		swap(A,r,i);                            //swap with the last element
		int q = partition_last(A,p,r);  //do a regular partition
		
		if(q-p == order_stat ||                         //if q happens to be equal to median
		   q-p-order_stat<(r-p)/100 ||                  //OR (Optimization) get close enough(Doesn't have to be very precise for LARGE array)
		   order_stat-(q-p)<(r-p)/100)                  // here I use 1% error bound.  
			                                         
		{
				return q;                          // return q
		}
		else if(q-p- order_stat >=(r-p)/100 )
		{
			return partition_median(A,p,q-1,order_stat);
		}
		else
		{
			return partition_median(A,q+1,r,order_stat-(q-p)-1);
		}
	}
	
	private int selection_medianOfMedians(int [][] A,int p,int r)   //We not only need the median, but also need the index of median in original array
	{
		//A[0][i] for indices
		//A[1][e] for elements
		if(r-p+1 <  50)                           //Optimization, if array size is less than 50, just use insertion sort
		{
			insertionSort(A, p, r);
			return (r-p)/2+p;
		}
		else
		{
			int groups = (int)Math.ceil((r-p+1)/5.0);
		
			int [][] temp = new int[2][groups];    //declare for future recursion use;
			for(int i = 0;i<groups;i++)
			{
				if(i != groups-1)
				{
					insertionSort(A,p+i*5,p+i*5+4);
					temp[0][i] = A[0][p+i*5+2];
					
					temp[1][i] = A[1][p+i*5+2];
					
				}
				else
				{
					insertionSort(A,p+i*5,r);
					temp[0][i] = A[0][(r-(p+i*5))/2+p+i*5];
					
					temp[1][i] = A[1][(r-(p+i*5))/2+p+i*5];
					
				}
			}
		    return selection_medianOfMedians(temp,0,temp[1].length-1);
		}
	}
	
	public int[][] convert_1D_to_Hash(int [] A,int p ,int r)
	{
		int [][] temp = new int [2][r-p+1];
		for(int i = 0;i<r-p+1;i++)
		{
			temp[0][i] = i+p;
			temp[1][i] = A[i+p];
		}
		return temp;
	}
	
	private void swap(int[]A,int i, int j)
	{
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	private void insertionSort(int array[][],int p,int r) 
	{
		if(r > p){
        
        for (int j = p+1; j <= r; j++) 
        {  
        	int index = array[0][j];
            int key = array[1][j];  
            int i = j-1;  
            while ( (i > p-1) && ( array[1][i] > key ) ) {  
                array [1][i+1] = array [1][i];
                array [0][i+1] = array [0][i];
                i--;  
            }
            array[0][i+1] = index;
            array[1][i+1] = key;  
        } 
		}
    }  
	
}
