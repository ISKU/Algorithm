/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.08.06
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/7432
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		TreeMap<String, Dir> graph = new TreeMap<String, Dir>();

		int N = input.nextInt();
		while (N-- > 0) {
			TreeMap<String, Dir> tree = graph;
			String[] dir = input.next().split("\\\\");

			for (String name : dir) {
				if (!tree.containsKey(name))
					tree.put(name, new Dir());
				tree = tree.get(name).names;
			}
		}

		for (String name : graph.keySet())
			dfs(name, "", graph);
	}

	private static void dfs(String name, String indent, TreeMap<String, Dir> tree) {
		System.out.println(indent + name);
		indent += " ";

		for (String subname : tree.get(name).names.keySet())
			dfs(subname, indent, tree.get(name).names);
	}

	private static class Dir {
		public TreeMap<String, Dir> names;

		public Dir() {
			this.names = new TreeMap<String, Dir>();
		}
	}
}