/*
Problem
Write a program that reads an array of N integer values and determines the element that has occurred the most number of times.

Input Format
The first line contains a single integer N, the number of elements in the array. The second line contains N space-separated integers, the elements of the array.

Output Format
Print a single integer representing the largest element among those that occur most frequently in the array.

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

9
Constraints
1 ≤ N ≤ 10,000 -10^9 ≤ Array elements ≤ 10^9
*/
import java.util.*;

public class LargestFrequentElementFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int small = arr[0];
        int frequent = map.get(arr[0]);

        for (int i = 1; i < n; i++) {
            int count = map.get(arr[i]);

            if (count > frequent) {
                frequent = count;
                small = arr[i];
            } else if (count == frequent && arr[i] > small) {
                // Tie in frequency → choose smaller element
                small = arr[i];
            }
        }

        System.out.println(small);
    }
}
