/*
Problem
Write a program that takes an array of integers as input and prints all the integers that occur an odd number of times, sorted in ascending order.

Input Format
The first line contains a single integer N, the number of elements in the array. The second line contains N space-separated integers, the elements of the array.

Output Format
Print the integers that occur an odd number of times in the array, sorted in ascending order, each on a new line. If a number occurs multiple odd times, it should be printed only once, if no odd times repeating elements print “No Repeating Elements”

Sample Inputs & Outputs
Sample Input 1

8
4 3 4 4 5 5 3 2
Sample Output 1

2
4
Sample Input 2

5
10 7 10 7 9
Sample Output 2

9
Constraints
1 ≤ N ≤ 10,000 -10^9 ≤ Array elements ≤ 10^9
*/

import java.util.*;

public class OddOccurrences {

    public static void main(String[] args) {
        // Read the input
        Scanner sc = new Scanner(System.in);
        
        // Number of elements in the array
        int N = sc.nextInt();
        
        // Array to store the integers
        int[] arr = new int[N];
        
        // Read the elements of the array
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Using a TreeMap to count the occurrences of each element
        // TreeMap will automatically sort the keys in ascending order
        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        
        // Count the frequency of each element
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // List to store the elements that occur an odd number of times
        List<Integer> oddOccurrences = new ArrayList<>();
        
        // Loop through the map and collect elements with odd occurrences
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddOccurrences.add(entry.getKey());
            }
        }
        
        // If no element has an odd number of occurrences
        if (oddOccurrences.isEmpty()) {
            System.out.println("No Repeating Elements");
        } else {
            // Print the elements with odd occurrences in ascending order
            for (int num : oddOccurrences) {
                System.out.println(num);
            }
        }
        
        sc.close();
    }
}
