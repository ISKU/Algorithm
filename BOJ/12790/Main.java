/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.23
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/12790
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			int hp = input.nextInt();
			int mp = input.nextInt();
			int at = input.nextInt();
			int df = input.nextInt();
			hp += input.nextInt();
			mp += input.nextInt();
			at += input.nextInt();
			df += input.nextInt();

			System.out.println(
					((hp <= 1) ? 1 : hp) + 
					((mp <= 1) ? 1 : mp) * 5 + 
					((at <= 0) ? 0 : at) * 2 + 
					df * 2);
		}
	}
}