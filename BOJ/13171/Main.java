/*
 * Author: Minho Kim (ISKU)
 * Date: April 12, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13171
 */

import java.util.*;

public class Main {

	private static final int MOD = (int) 1e9 + 7;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long X = sc.nextLong();

		long answer = 1;
		while (X > 0) {
			if ((X & 1) == 1)
				answer = ((answer % MOD) * (A % MOD)) % MOD;
			A = ((A % MOD) * (A % MOD)) % MOD;
			X /= 2;
		}

		System.out.print(answer);
	}
}