/*
Problem
Write a program that reads an array of N integer values and identifies the element that has occurred the most number of times.

Input Format
The first line contains a single integer N, the number of elements in the array. The second line contains N space-separated integers, the elements of the array.

Output Format
Print a single integer, the most frequent element in the array. If there are multiple such elements, print the one that appeared first.

Sample Inputs & Outputs
Sample Input 1

7
1 2 3 2 4 3 5
Sample Output 1

2
Sample Input 2

10
4 5 9 11 9 4 8 15 8 6
Sample Output 2

4
Constraints
1 ≤ N ≤ 10,000 -10^9 ≤ Array elements ≤ 10^9
*/

import java.util.*;

public class FrequenceOfElementUsingMap{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // Number of elements
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // Map to count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Count frequencies
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Find most frequent (with tie-breaking on first occurrence)
        int mostFrequent = arr[0];
        int maxCount = 0;  // start at 0 (safe)

        for (int num : arr) {  // iterate in original order for "first occurrence"
            int count = freqMap.get(num);
            if (count > maxCount) {
                maxCount = count;
                mostFrequent = num;
            }
        }

        System.out.println(mostFrequent);
    }
}
