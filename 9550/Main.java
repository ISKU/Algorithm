/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9550
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			int N = input.nextInt();
			int K = input.nextInt();
			int sum = 0;

			for (int count = 0; count < N; count++)
				sum += input.nextInt() / K;

			System.out.println(sum);
		}
	}
}