/*
 * Author: Minho Kim (ISKU)
 * Date: April 13, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15649
 */

import java.util.*;

public class Main {

	private static int N, M;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		dfs(0, "", new ArrayList<Integer>() {{
			for (int i = 1; i <= N; i++)
				add(i);
		}});

	}

	private static void dfs(int step, String result, ArrayList<Integer> list) {
		if (step >= M) {
			System.out.println(result);
			return;
		}

		for (int n : list) {
			ArrayList<Integer> temp = (ArrayList<Integer>) list.clone();
			temp.remove(Integer.valueOf(n));
			dfs(step + 1, result + n + " ", temp);
		}
	}
}