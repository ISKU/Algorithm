/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.23
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1002
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			int x1 = input.nextInt();
			int y1 = input.nextInt();
			int r1 = input.nextInt();
			int x2 = input.nextInt();
			int y2 = input.nextInt();
			int r2 = input.nextInt();

			int dist = ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1));

			if (x1 == x2 && y1 == y2)
				System.out.println(r1 == r2 ? -1 : 0);
			else {
				if (dist > (r1 + r2) * (r1 + r2))
					System.out.println(0);
				else if (dist == (r1 + r2) * (r1 + r2))
					System.out.println(1);
				else if (dist > (r1 - r2) * (r1 - r2))
					System.out.println(2);
				else if (dist == (r1 - r2) * (r1 - r2))
					System.out.println(1);
				else
					System.out.println(0);
			}
		}
	}
}