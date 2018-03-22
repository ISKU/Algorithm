/*
 * Author: Minho Kim (ISKU)
 * Date: March 22, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/954/B
 */

import java.util.*;

public class B {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String line = sc.next();

		int oper = N;
		for (int i = 1; i <= N / 2; i++)
			if (i + i <= N && line.substring(0, i).equals(line.substring(i, i + i)))
				oper = Math.min(oper, N + 1 - i);

		System.out.print(oper);
	}
}