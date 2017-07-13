/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.10
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2986
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		long N = new Scanner(System.in).nextInt();
		long mod = 1;

		do {
			mod = mod + 1;
			if (mod * mod > N)
				mod = N;
		} while (N % mod != 0);

		System.out.println(N - N / mod);
	}
}