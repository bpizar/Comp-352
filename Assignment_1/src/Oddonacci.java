import java.util.Scanner;

public class Oddonacci 
{
	//counter to track number recursion calls in recursiveOddo
	private static int numOfCalls = 0;
	//counter to track number of iterations in linearOddo
	private static int numOfIterations = 0;

	public static void main(String[] args)
	{
		Scanner kb =  new Scanner(System.in);
		System.out.println();
		System.out.print("Input Oddo(__): ");
		int n = kb.nextInt();
		System.out.println();
		
		//test recursive oddonacci
		long odd = recursiveOddo(n ,1,1,1);
		System.out.println();
		System.out.println("recursiveOddo(" + n + ") =  " + odd);
		System.out.println("Number of Calls: " + numOfCalls);
		System.out.println();

		//test linear oddonacci
		long odd2 = linearOddo(n);
		System.out.println();
		System.out.println("Oddo(" + n + ") =  " + odd2);
		System.out.println("Number of Iterations: " + numOfIterations);


		kb.close();
		
	}
	/**
	 * recursiveOddo calculates the oddonacci value at position n
	 * It is O(n)
	 * @param n
	 * @param i
	 * @param j
	 * @param k
	 * @return i+j+k for (n > 3) OR k for (n <= 3)
	 */
	public static long recursiveOddo (int n,long i , long j, long k)
	{	
		//base case	
		if ( n <= 3)
		{
			k = 1;
			return k;
		}
		//recursive step
		else
		{
			numOfCalls++; // count number of recursive calls
			k = recursiveOddo(n - 1,j,k,i+j+k);
		}
		return i+j+k;						
	}
	
	/**
	 * linearOddo calculates the oddonacci sequence up to position n
	 * and the value at position n
	 * It is O(n) running in one for loop
	 * @param n
	 * @return baseArr[2]
	 */
	public static long linearOddo(int n)
	{
		
		long i = 1, j = 1, k = 1;
		long[] baseArr = {i,j,k};
		//System.out.print(baseArr[0] + " " + baseArr[1] + " " + baseArr[2] + " ");
		
		for (int c = 0 ; c < n - 3 ; c++,numOfIterations++) // count number of iterations
		{
			baseArr[0] = j;
			baseArr[1] = k;
			baseArr[2] = i+j+k;
			
			//System.out.print( baseArr[2] + " ");
			
			i = baseArr[0];
			j = baseArr[1];
			k = baseArr[2];

		}
		return baseArr[2];
	}

}
