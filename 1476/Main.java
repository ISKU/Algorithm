/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.28
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1476
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int e = input.nextInt();
		int s = input.nextInt();
		int m = input.nextInt();

		int n = s - 1;
		while ((n % 15 != e - 1) || (n % 19 != m - 1))
			n += 28;
		System.out.print(n + 1);
	}
}