/*
 * Author: Minho Kim (ISKU)
 * Date: April 1, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15638
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		boolean[] prime = new boolean[100001];
		for (int i = 2; i * i <= 1e5; i++)
			if (!prime[i])
				for (int j = i * i; j <= 1e5; j += i)
					prime[j] = true;

		System.out.print(prime[new Scanner(System.in).nextInt()] ? "No" : "Yes");
	}
}