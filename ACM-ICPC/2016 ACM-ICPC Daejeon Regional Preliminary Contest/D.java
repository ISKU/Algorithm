/* 
 * Author: Minho Kim (ISKU)
 * Date: 2016.10.01
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * http://icpckorea.org/2016/ONLINE/problem.pdf
 */

import java.util.Scanner;

public class D {

	private static long MOD = 31991;
	private static int d;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		d = input.nextInt();
		int t = input.nextInt();
		long[][] D = new long[d][d];
		long[][] answer = new long[d][d];

		for (int i = 0; i < d; i++)
			D[0][i] = answer[i][i] = 1;
		for (int i = 1; i < d; i++)
			D[i][i - 1] = 1;

		while (t > 0) {
			if (t % 2 == 1)
				answer = multiply(D, answer);
			D = multiply(D, D);
			t /= 2;
		}

		System.out.print(answer[0][0]);
	}

	private static long[][] multiply(long[][] A, long[][] B) {
		long[][] ret = new long[d][d];

		for (int i = 0; i < d; i++)
			for (int j = 0; j < d; j++)
				for (int k = 0; k < d; k++)
					ret[i][j] = (ret[i][j] + (A[i][k] * B[k][j]) % MOD) % MOD;

		return ret;
	}
}