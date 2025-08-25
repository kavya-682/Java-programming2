/*
 *Problem
Given an array of integers, count the number of subarrays with exactly K different elements.

Input Format
The first line contains two integers n and k.

The second line contains n integers representing the elements of the array.

Output Format
Print the number of subarrays with exactly k different elements.

Sample Inputs & Outputs
Sample Input 1

5 2
1 2 1 2 3
Sample Output 1

7
Sample Input 2

5 3
1 2 1 2 3
Sample Output 2

3
Constraints
1 ≤ n ≤ 100000 1 ≤ arr[i] ≤ 100000 1 ≤ k ≤ n
 */
package in.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DiffrentArrayWithExactlyKDiffrentElements{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        
        System.out.println(exactlyK(nums, k));

	}
	private static int atMostK(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, result = 0;

        for (int right = 0; right < nums.length; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            while (freq.size() > k) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) {
                    freq.remove(nums[left]);
                }
                left++;
            }

            result += right - left + 1;
        }

        return result;
    }

    private static int exactlyK(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }


}

