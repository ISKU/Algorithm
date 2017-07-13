/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.16
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5063
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			int r = input.nextInt();
			int e = input.nextInt();
			int c = input.nextInt();

			if (r == e - c)
				System.out.println("does not matter");
			else if (r > e - c)
				System.out.println("do not advertise");
			else
				System.out.println("advertise");
		}
	}
}