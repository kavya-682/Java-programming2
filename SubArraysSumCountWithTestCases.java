/*
Problem
You are given an integer array `arr` of size `N` and an integer `K`. Your task is to find the total number of subarrays in the given array whose sum of elements is equal to `K`. A subarray is defined as a contiguous block of elements in the array.

Input Format
The first line contains an integer `T`, the number of test cases.

For each test case:

- The first line contains two integers `N` and `K`, representing the size of the array and the target sum.

- The second line contains `N` space-separated integers, representing the elements of `arr`.

Output Format
For each test case, print the total count of subarrays whose sum is equal to `K`.

Explanation:  
For example, if `N = 4`, `arr = [3, 1, 2, 4]`, and `K = 6`, the subarrays `[2, 4]` and `[3, 1, 2]` both sum up to 6, resulting in an output of 2.

Sample Inputs & Outputs
Sample Input 1

2
4 6
3 1 2 4
3 3
1 2 3
Sample Output 1

2
2
Sample Input 2

2
3 7
1 2 3
4 9
6 3 5 2
Sample Output 2

0
1
Constraints
1 <= T <= 100 1 <= N <= 10^5 -10^4 <= arr[i] <= 10^4 -10^9 <= K <= 10^9 The sum of `N` over all test cases will not exceed 10^6.
*/
package in.java;

import java.util.Scanner;

public class SubArraysSumCountWithTestCases {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
	
		int T = sc.nextInt(); // number of test cases
		int[] results = new int[T]; // store results for all test cases
		
         for(int t=0;t<T;t++) 
        {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) 
            {
                arr[i] = sc.nextInt();
            }
            results[t]=  arrayWithSum(arr,K);
        }    
        
        for (int res : results) {
            System.out.println(res);
        }

	}
	
	//subarrays with exact sum
	public static int arrayWithSum(int[] array, int k)
	{    
		int count=0;
		
		for(int size=1;size<=array.length;size++)
		{    
			for(int i=0;i<=array.length-size;i++)
			{  
				int sum =0;
				for(int j=i;j<i+size;j++)
				{
					 sum = sum + array[j];
				}
				if(sum == k)
				{
					count++;
				}
			}
		}
		return count;
	}

}