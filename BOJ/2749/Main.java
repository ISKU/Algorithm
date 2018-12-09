/*
 * Author: Minho Kim (ISKU)
 * Date: December 8, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2749
 */

import java.util.*;
import java.math.*;

public class Main {

	private static final long MOD = 1_000_000;
	private static final BigInteger TWO = BigInteger.valueOf(2);

	public static void main(String... args) {
		BigInteger N = new Scanner(System.in).nextBigInteger().subtract(BigInteger.ONE);

		long[][] mat = new long[][] { { 1, 0 }, { 0, 1 } };
		long[][] fibo = new long[][] { { 1, 1, }, { 1, 0 } };
		while (N.compareTo(BigInteger.ZERO) > 0) {
			if (N.remainder(TWO).compareTo(BigInteger.ONE) == 0)
				mat = mult(mat, fibo);
			fibo = mult(fibo, fibo);
			N = N.divide(TWO);
		}

		System.out.print(mat[0][0]);
	}

	private static long[][] mult(long[][] A, long[][] B) {
		long[][] mat = new long[2][2];

		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 2; j++)
				for (int k = 0; k < 2; k++)
					mat[i][j] = (mat[i][j] + (A[i][k] * B[k][j]) % MOD) % MOD;

		return mat;
	}
}
