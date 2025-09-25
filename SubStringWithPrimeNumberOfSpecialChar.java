/*
Problem
Given a string, print all the substrings which have a prime number of special characters. Special characters are defined as non-alphanumeric characters. A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.

Input Format
A single line containing a string `s`.

Output Format
Print all the substrings that contain a prime number of special characters, each substring on a new line.

Sample Inputs & Outputs
Sample Input 1

hello123*#
Sample Output 1

*#
3*#
23*#
123*#
o123*#
lo123*#
llo123*#
ello123*#
hello123*#
Sample Input 2

ab@c!d*
Sample Output 2

@c!
!d*
b@c!
@c!d
c!d*
ab@c!
b@c!d
@c!d*
ab@c!d
b@c!d*
ab@c!d*
*/

package in.java;

import java.util.Scanner;

public class SubStringWithPrimeNumberOfSpecialChar {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.nextLine();
        
		for(int size=1;size<=input.length();size++)
		{
			for(int i=0;i<=input.length()-size;i++)
			{   
				String s ="";
				for(int j=i;j<i+size;j++)
				{
					s = s+input.charAt(j);
				}
				if(isHavePrimeNumberSpceChar(s))
				{
					System.out.println(s);
				}
			}
		}
	}
	
	//check array have special char at even number of times 
	public static boolean isHavePrimeNumberSpceChar(String s)
	{
		int conut=0;
		for(int i=0;i<s.length();i++)
		{  
			char c = s.charAt(i);
			if( !((c>='A'&& c<='Z') || (c>='a'&& c<='z') || (c>='0' && c<='9')|| c==' '))
			{
				conut++;
			}
		}
		
		if(conut<2)
		{
			return false;
		}
		
		for( int i=2;i*i<=conut;i++)
		{
			if(conut%i == 0)
			{
				return false;
			}
		}
		return true;
	}

}
