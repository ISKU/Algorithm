/*
 * Author: Minho Kim (ISKU)
 * Date: August 24, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15988
 */

import java.util.*;

public class Main {

	private static final long MOD = 1_000_000_009;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long[] array = new long[1000001];
		array[1] = 1;
		array[2] = 2;
		array[3] = 4;
		for (int i = 4; i <= 1000000; i++)
			array[i] = (array[i - 1] + array[i - 2] + array[i - 3]) % MOD;

		int T = sc.nextInt();
		while (T-- > 0)
			System.out.println(array[sc.nextInt()] % MOD);
	}
}