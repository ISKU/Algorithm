/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.23
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4153
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			int[] angle = new int[] { input.nextInt(), input.nextInt(), input.nextInt() };
			if (angle[0] == 0 && angle[1] == 0 && angle[2] == 0)
				break;

			Arrays.sort(angle);
			System.out.println((Math.hypot(angle[0], angle[1]) == angle[2]) ? "right" : "wrong");
		}
	}
}