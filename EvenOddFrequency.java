/*
Problem
Develop a program that reads an array of integers and prints all the even elements that occur an odd number of times.

Input Format
The first line contains a single integer N, the number of elements in the array. The second line contains N space-separated integers, representing the elements of the array.

Output Format
Print the even integers that occur an odd number of times in the array, each on a new line. If an even number is found to occur an odd number of times, it should be printed only once, in the order it first appears. If no even numbers repeating odd times print “No Repeating Elements”.

Sample Inputs & Outputs
Sample Input 1

7
2 4 4 4 6 6 2
Sample Output 1

4
Sample Input 2

10
12 14 12 14 16 18 18 16 16 20
Sample Output 2

16
20
Constraints
1 ≤ N ≤ 10,000
-10^9 ≤ Array elements ≤ 10^9
*/

import java.util.*;

public class EvenOddFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // Read the number of elements
        int[] arr = new int[N];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Read array and build frequency map
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }

        Set<Integer> printed = new HashSet<>();
        boolean found = false;

        // Loop through array to maintain order
        for (int num : arr) {
            if (num % 2 == 0 && frequencyMap.get(num) % 2 == 1 && !printed.contains(num)) {
                System.out.println(num);
                printed.add(num);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Repeating Elements");
        }

        scanner.close();
    }
}
