/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.30
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10872
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int factorial = 1;
		for (int number = input.nextInt(); number >= 1; number--)
			factorial *= number;
		System.out.println(factorial);
	}
}