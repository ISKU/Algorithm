/*
 * Author: Minho Kim (ISKU)
 * Date: April 1, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15633
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		int[] divisor = new int[10001];
		for (int i = 1; i <= 1e4; i++)
			for (int j = i; j <= 1e4; j += i)
				divisor[j] += i;

		System.out.print(divisor[new Scanner(System.in).nextInt()] * 5 - 24);
	}
}