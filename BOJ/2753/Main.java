/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.08
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2753
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int year = input.nextInt();

		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
			System.out.println(1);
		else
			System.out.println(0);
	}
}