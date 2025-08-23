import java.util.Scanner;

public class LongestSortedArrayLength {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] array = new int[n];
		for(int i=0;i<n;i++)
		{
			array[i] = scanner.nextInt();
		}
		longestSortArray(array);
		
	}
	public static void longestSortArray(int[] array)
	{    
		
		for(int size=array.length;size>0;size--)
		{   int tempArray[] =  new int[size]; 
			for(int i=0;i<=array.length-size;i++)
			{
				for(int j=i;j<i+size;j++)
				{
					 tempArray[j-i] = array[j] ;
				}
				if(isSort(tempArray))
				{
					System.out.println(tempArray.length);
					return;
				}
			}
		}
	}
	
	private static boolean isSort(int[] tempArray) 
	{
		
		
		for(int i=0;i<tempArray.length-1;i++)
		{
			if(tempArray[i] >tempArray[i+1])
			{
				return false;
			}
		}
		return true;
		
	}

}
