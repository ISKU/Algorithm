/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.12.26
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5567
 */

import java.util.*;

public class Main {

	private static ArrayList<ArrayList<Integer>> graph;
	private static int V, E;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		V = input.nextInt();
		E = input.nextInt();

		graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < V; i++)
			graph.add(new ArrayList<Integer>());

		for (int i = 0; i < E; i++) {
			int first = input.nextInt() - 1;
			int second = input.nextInt() - 1;
			graph.get(first).add(second);
			graph.get(second).add(first);
		}

		HashSet<Integer> set = new HashSet<Integer>();
		for (int friend : graph.get(0)) {
			set.add(friend);
			for (int ff : graph.get(friend))
				set.add(ff);
		}

		System.out.print(set.size() - 1);
	}
}