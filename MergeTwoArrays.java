/*
Problem
You are given two sorted arrays, `arr1` and `arr2`, each containing `n` integers. Your task is to merge these two arrays into a single sorted sequence in-place without using any additional space. After merging: - The first `n` smallest elements should be in `arr1`. - The remaining `n` elements should be in `arr2`. Both `arr1` and `arr2` should remain sorted after the operation.

Input Format
The first line contains a single integer `n`, representing the number of elements in each array. The second line contains `n` space-separated integers, representing the elements of `arr1`. The third line contains `n` space-separated integers, representing the elements of `arr2`.

Output Format
Print two lines: - The first line should contain the first `n` smallest elements in `arr1`, sorted in ascending order. - The second line should contain the remaining `n` elements in `arr2`, sorted in ascending order.

Sample Inputs & Outputs
Sample Input 1

4
1 3 5 7
0 2 6 8
Sample Output 1

0 1 2 3
5 6 7 8
Sample Input 2

5
10 12 14 16 18
5 6 7 8 9
Sample Output 2

5 6 7 8 9
10 12 14 16 18
*/

import java.util.Scanner;
public class MergeTwoArrays {

	public static void main(String[] args) {
		
         Scanner scanner = new Scanner(System.in);
         int n = scanner.nextInt();
         int[] array1=new int[n];
         for(int i=0;i<n;i++)
         {
        	 array1[i]=scanner.nextInt();
         }
         
         int[] array2=new int[n];
         for(int i=0;i<n;i++)
         {
        	 array2[i]=scanner.nextInt();
         }
         
         
         // Step 1: Merge into one array
         int[] merged = new int[2 * n];
         for (int i = 0; i < n; i++) merged[i] = array1[i];
         for (int i = 0; i < n; i++) merged[n + i] = array2[i];
         
      // Step 2: Bubble sort
         for (int i = 0; i < merged.length - 1; i++) {
             for (int j = 0; j < merged.length - i - 1; j++) {
                 if (merged[j] > merged[j + 1]) {
                     int temp = merged[j];
                     merged[j] = merged[j + 1];
                     merged[j + 1] = temp;
                 }
             }
         }
         
      // Step 3: Split back into arr1 and arr2
         for (int i = 0; i < n; i++) array1[i] = merged[i];
         for (int i = 0; i < n; i++) array2[i] = merged[n + i];

         // Output
         for (int i = 0; i < n; i++) System.out.print(array1[i] + " ");
         System.out.println();
         for (int i = 0; i < n; i++) System.out.print(array2[i] + " ");
         
	}

}

