/*
 * Author: Minho Kim (ISKU)
 * Date: May 15, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15721
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		System.out.print(run(sc.nextInt(), sc.nextInt(), sc.nextInt()));
	}

	private static int run(int A, int T, int C) {
		int bun = 0;
		int degi = 0;
		int n = 2;

		while (true) {
			if (++bun == T && C == 0)
				return (bun + degi - 1) % A;
			if (++degi == T && C == 1)
				return (bun + degi - 1) % A;
			if (++bun == T && C == 0)
				return (bun + degi - 1) % A;
			if (++degi == T && C == 1)
				return (bun + degi - 1) % A;

			for (int i = 1; i <= n; i++)
				if (++bun == T && C == 0)
					return (bun + degi - 1) % A;
			for (int i = 1; i <= n; i++)
				if (++degi == T && C == 1)
					return (bun + degi - 1) % A;

			n++;
		}
	}
}