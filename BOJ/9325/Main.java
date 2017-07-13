/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.16
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9325
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			int sum = input.nextInt();
			for (int i = input.nextInt(); i > 0; i--)
				sum = sum + (input.nextInt() * input.nextInt());

			System.out.println(sum);
		}
	}
}