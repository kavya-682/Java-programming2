/*
Problem
Develop a program that reads an array of integers and prints all the elements that occur exactly once.

Input Format
The first line contains a single integer N, the number of elements in the array.

The second line contains N space-separated integers, the elements of the array.

Output Format
Print the elements that occur exactly once in the array, each on a new line. If no unique elements print “No Unique Elements”

Sample Inputs & Outputs
Sample Input 1

7
1 2 3 2 4 3 5
Sample Output 1

1
4
5
Sample Input 2

10
4 5 9 11 9 4 8 15 8 6
Sample Output 2

5
11
15
6
Constraints
1 ≤ N ≤ 10,000 -10^9 ≤ Array elements ≤ 10^9
*/

import java.util.*;

public class UniqueElementsUsingMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Count frequencies using HashMap
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Collect and print elements that occur exactly once
        boolean hasUnique = false;
        for (int num : arr) { // keep insertion order
            if (freqMap.get(num) == 1) {
                System.out.println(num);
                hasUnique = true;
            }
        }

        // If no unique elements
        if (!hasUnique) {
            System.out.println("No Unique Elements");
        }

        sc.close();
    }
}
