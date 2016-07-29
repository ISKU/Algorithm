/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.29
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10952
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		while (true) {
			int sumOfTwoNumber = input.nextInt() + input.nextInt();
			if (sumOfTwoNumber == 0)
				break;
			else
				System.out.println(sumOfTwoNumber);
		}
	}
}