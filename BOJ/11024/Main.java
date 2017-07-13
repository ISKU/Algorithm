/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.06
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11024
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		for (input.nextLine(); testCase > 0; testCase--) {
			int sum = 0, index = 0;
			for (String[] arrayNumber = input.nextLine().split(" "); index < arrayNumber.length; index++)
				sum = sum + Integer.parseInt(arrayNumber[index]);
			System.out.println(sum);
		}
	}
}