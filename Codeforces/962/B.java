/*
 * Author: Minho Kim (ISKU)
 * Date: April 10, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/962/B
 */

import java.util.*;

public class B {

	private static int N;
	private static char[] seat;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		seat = sc.next().toCharArray();

		ArrayList<Integer> candidate = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int count = dfs(i, 0);
			if (count != 0)
				candidate.add(count);
			i += count;
		}
		Collections.sort(candidate, Collections.reverseOrder());

		int answer = 0;
		for (int count : candidate) {
			int mid = count / 2;
			int a = 0, b = 0;

			if (count % 2 == 0) {
				a = (A >= mid) ? mid : A;
				b = (B >= mid) ? mid : B;
			} else {
				a = (A > B) ? ((A >= mid + 1) ? mid + 1 : A) : ((A >= mid) ? mid : A);
				b = (A > B) ? ((B >= mid) ? mid : B) : ((B >= mid + 1) ? mid + 1 : B);
			}

			A -= a;
			B -= b;
			answer += a + b;
		}

		System.out.print(answer);
	}

	private static int dfs(int i, int n) {
		if (i >= N || seat[i] == '*')
			return n;
		return dfs(i + 1, n + 1);
	}
}