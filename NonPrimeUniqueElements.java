/*
Problem
Create a program that reads an array of integers and prints all the non-prime numbers that occur exactly once.

Input Format
The first line contains a single integer N, the number of elements in the array. The second line contains N space-separated integers, the elements of the array.

Output Format
Print the non-prime numbers that occur exactly once in the array, each on a new line. If a non-prime number is unique, it should be printed in the order it first appears.

Sample Inputs & Outputs
Sample Input 1

8
4 6 7 4 8 9 10 11
Sample Output 1

6
8
9
10
Sample Input 2

5
22 15 13 19 15
Sample Output 2
22
Constraints
1 ≤ N ≤ 10,000 1 ≤ Array elements ≤ 10^6
*/

import java.util.*;

public class NonPrimeUniqueElements {

    public static boolean isNonPrime(int a) {
        if (a < 2) return true;
        if (a == 2) return false;
        if (a % 2 == 0) return true;
        for (int i = 3; i*i<= a; i += 2) {
            if (a % i == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (isNonPrime(num)) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        Set<Integer> keys = map.keySet();

        for (int key : keys) {
            if (map.get(key) == 1) {
                System.out.println(key);
            }
        }

        sc.close();
    }
}

