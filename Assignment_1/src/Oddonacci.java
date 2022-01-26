import java.util.Scanner;

public class Oddonacci 
{
	//counter to track number recursion calls
	private static int numOfCalls = 0;
	
	public static void main(String[] args)
	{
		Scanner kb =  new Scanner(System.in);
		System.out.println();
		System.out.print("Input Oddo(__): ");
		int n = kb.nextInt();
		System.out.println();
		
		//test recursive oddonacci
		long[] baseArr = {0,0,0};
		long [] index = {1,1,1};
		long odd = recursiveOddo(n ,baseArr,index);
		System.out.println();
		System.out.println("recursiveOddo(" + n + ") =  " + odd);
		System.out.println("Number of Calls: " + numOfCalls);
		System.out.println();
		System.out.println();

		//test linear oddonacci
		long odd2 = oddo(n);
		System.out.println();
		System.out.println("Oddo(" + n + ") =  " + odd2);

		kb.close();
		
	}
	public static long recursiveOddo (int n,long[] baseArr,long [] index)
	{	
		//initialize index values
		if (numOfCalls == 0)
		{
			index[0] = 1;
			index[1] = 1;
			index[2] = 1;
			System.out.print( index[0] + " " + index[1] + " " + index[2] + " ");
		}
		//base case	
		if ( n <= 3)
			return baseArr[2];
		else
		{
			baseArr[0] = index[1];
			baseArr[1] = index[2];
			baseArr[2] = index[0] + index[1] + index[2];
			
			System.out.print( baseArr[2] + " ");
			
			index[0] = baseArr[0];
			index[1] = baseArr[1];
			index[2] = baseArr[2];

		}
		
		//recursive step
		numOfCalls++;
		return recursiveOddo(n-1,index,baseArr);
				
	}
	/**
	 * Oddonacci calculates the Oddonacci sequence up to position n
	 * and the value at position n
	 * It is O(n) running in one for
	 * @param n
	 * @return baseArr[2]
	 */
	public static long oddo(int n)
	{
		
		long i = 1, j = 1, k = 1;
		long[] baseArr = {i,j,k};
		System.out.print(baseArr[0] + " " + baseArr[1] + " " + baseArr[2] + " ");
		
		for (int c = 0 ; c < n - 3 ; c++)
		{
			baseArr[0] = j;
			baseArr[1] = k;
			baseArr[2] = i+j+k;
			
			System.out.print( baseArr[2] + " ");
			
			i = baseArr[0];
			j = baseArr[1];
			k = baseArr[2];

		}
		return baseArr[2];
	}

}
