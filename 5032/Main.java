/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.28
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5032
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int e = input.nextInt();
		int f = input.nextInt();
		int c = input.nextInt();

		int sum = 0;
		int total = e + f;
		while (total >= c) {
			int cur = total / c;
			total = total % c;
			sum += cur;
			total += cur;
		}

		System.out.print(sum);
	}
}