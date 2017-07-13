/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10768
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int month = input.nextInt();
		int day = input.nextInt();

		if (month >= 3)
			System.out.print("After");
		else if (month <= 1)
			System.out.print("Before");
		else if (day <= 17)
			System.out.print("Before");
		else if (day >= 19)
			System.out.print("After");
		else
			System.out.print("Special");
	}
}