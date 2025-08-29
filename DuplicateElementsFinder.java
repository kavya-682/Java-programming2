/*
Problem
Given an array of integers, Write a program to print all the duplicate elements present in the array by insertion order and each duplicate element should be printed in new line.

Input Format
The first line consists of N, size of the array

Second line consists of N space separated integers which are the elements of the array

Output Format
Print all the duplicate elements present in the array on new line.

Sample Inputs & Outputs
Sample Input 1

7
1 2 3 2 4 3 5
Sample Output 1

2
3
Sample Input 2

10
4 5 9 11 9 4 8 15 8 6
Sample Output 2

4
9
8
Constraints
1 <= T <= 10 1 <= N <= 100000 1 <= HEIGHTS[i] <= 10001 <= N <= 10^5

-10^5 <= arr[i] <= 10^5
*/
import java.util.*;

public class DuplicateElementsFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> freq = new HashMap<>();
        HashSet<Integer> printed = new HashSet<>(); // To avoid printing duplicates multiple times

        for (int i = 0; i < n; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);

            // When frequency becomes 2 → it's a duplicate, print once
            if (freq.get(arr[i]) == 2 && !printed.contains(arr[i])) {
                System.out.println(arr[i]);
                printed.add(arr[i]);
            }
        }
    }
}


