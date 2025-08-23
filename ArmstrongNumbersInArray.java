package in.java;

import java.util.Scanner;

public class ArmstrongNumbersInArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] array = new int[n];
		for(int i=0;i<n;i++)
		{
			array[i] = scanner.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			if(isArmstrongNumber(array[i]))
			{
				System.out.println(array[i]);
			}
		}

	}
	
	public static boolean isArmstrongNumber(int n) {
        int arm = 0;
        int count = 0; 
        int temp = n;

        // count digits
        int t = temp;
        while (t > 0) {
            count++;
            t = t / 10;
        }

        // calculate Armstrong sum
        t = temp;
        while (t > 0) {
            int last = t % 10;
            arm = arm + (int) Math.pow(last, count);
            t = t / 10;
        }

        return arm == n;
    }
	

}
