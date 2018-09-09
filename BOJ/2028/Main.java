/*
 * Author: Minho Kim (ISKU)
 * Date: September 7, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2028
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int NN = N * N;

			boolean check = true;
			while (N > 0) {
				if (N % 10 != NN % 10)
					check = false;
				N /= 10;
				NN /= 10;
			}

			System.out.println(check ? "YES" : "NO");
		}
	}
}