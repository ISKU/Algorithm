/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.12.26
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15178
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();

		while (N-- > 0) {
			int a = input.nextInt();
			int b = input.nextInt();
			int c = input.nextInt();
			System.out.printf("%d %d %d %s\n", a, b, c, (a + b + c) == 180 ? "Seems OK" : "Check");
		}
	}
}