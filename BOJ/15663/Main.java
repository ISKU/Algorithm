/*
 * Author: Minho Kim (ISKU)
 * Date: April 14, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15663
 */

import java.util.*;

public class Main {

	private static int M;
	private static HashSet<String> set;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		M = sc.nextInt();

		ArrayList<Integer> list = new ArrayList<>();
		while (N-- > 0)
			list.add(sc.nextInt());

		Collections.sort(list);
		set = new HashSet<String>();
		dfs(0, "", list);
	}

	private static void dfs(int s, String result, ArrayList<Integer> list) {
		if (s >= M) {
			if (set.contains(result))
				return;

			set.add(result);
			System.out.println(result);
			return;
		}

		for (Integer n : list) {
			ArrayList<Integer> temp = (ArrayList<Integer>) list.clone();
			temp.remove(n);
			dfs(s + 1, result + n + " ", temp);
		}
	}
}