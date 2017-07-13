/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10178
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			int candy = input.nextInt();
			int piece = input.nextInt();
			System.out.printf("You get %d piece(s) and your dad gets %d piece(s).\n", candy / piece, candy % piece);
		}
	}
}