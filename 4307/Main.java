/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.23
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4307
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			int stick = input.nextInt();
			int min = Integer.MIN_VALUE;
			int max = Integer.MIN_VALUE;

			for (int i = input.nextInt(); i > 0; i--) {
				int ant = input.nextInt();
				min = Math.max(min, (ant > stick / 2) ? stick - ant : ant);
				max = Math.max(max, (ant > stick / 2) ? ant : stick - ant);
			}

			System.out.println(min + " " + max);
		}
	}
}