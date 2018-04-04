/*
 * Author: Minho Kim (ISKU)
 * Date: April 4, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1003
 */

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int[] zero = new int[41];
		int[] one = new int[41];
		zero[0] = one[1] = 1;

		for (int i = 2; i <= 40; i++) {
			zero[i] = zero[i - 1] + zero[i - 2];
			one[i] = one[i - 1] + one[i - 2];
		}

		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			System.out.printf("%d %d\n", zero[n], one[n]);
		}
	}
}