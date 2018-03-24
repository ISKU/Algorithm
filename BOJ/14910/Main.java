/*
 * Author: Minho Kim (ISKU)
 * Date: March 23, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14910
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		StringTokenizer st = new StringTokenizer(new Scanner(System.in).nextLine());

		int prev = Integer.parseInt(st.nextToken());
		boolean desc = false;
		while (st.hasMoreTokens()) {
			int n = Integer.parseInt(st.nextToken());
			if (prev > n)
				desc = true;
			prev = n;
		}

		System.out.print(desc ? "Bad" : "Good");
	}
}