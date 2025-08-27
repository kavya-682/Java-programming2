/*
Problem
Develop a program that takes an array of N integer values as input and identifies the element that has occurred the most number of times.

Input Format
The first line contains a single integer N, representing the number of elements in the array. The second line contains N space-separated integers, detailing the elements of the array.

Output Format
Print a single integer representing the most frequently occurring element in the array. If there is a tie in frequency, print the element that appeared last among them.

Sample Inputs & Outputs
Sample Input 1

7
1 2 3 2 4 3 5
Sample Output 1

3
Sample Input 2

10
4 5 9 11 9 4 8 15 8 6
Sample Output 2

8
Constraints
1 ≤ N ≤ 10,000 -10^9 ≤ Array elements ≤ 10^9
*/

import java.util.*;

public class MostFrequentElementFromLast {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // Map to store frequencies
        HashMap<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        int result = arr[0];  // Default to first element

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);

            // If current num has higher frequency, update result
            if (freq.get(num) > maxFreq) {
                maxFreq = freq.get(num);
                result = num;
            }
            // If freq == maxFreq, do nothing because we want the first occurrence
        }

        System.out.println(result);
    }
}
