import java.util.Scanner;

public class Oddonacci 
{

	public static void main(String[] args)
	{
		Scanner kb =  new Scanner(System.in);
		System.out.println();
		System.out.print("Input Oddo(__): ");
		int n = kb.nextInt();
		System.out.println();
	
		long odd = oddo(n);
		System.out.println();
		System.out.println("Oddo(" + n + ") =  " + odd);

		kb.close();
		
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
