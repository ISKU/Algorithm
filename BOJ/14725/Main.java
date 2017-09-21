/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.09.17
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14725
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		TreeMap<String, Child> tree = new TreeMap<String, Child>();

		int N = input.nextInt();
		while (N-- > 0) {
			TreeMap<String, Child> subtree = tree;
			String[] childNames = new String[input.nextInt()];

			for (int i = 0; i < childNames.length; i++)
				childNames[i] = input.next();

			for (String name : childNames) {
				if (!subtree.containsKey(name))
					subtree.put(name, new Child());
				subtree = subtree.get(name).childs;
			}
		}

		for (String name : tree.keySet())
			dfs(name, "", tree);
	}

	private static void dfs(String name, String indent, TreeMap<String, Child> tree) {
		System.out.println(indent + name);
		indent += "--";

		for (String subname : tree.get(name).childs.keySet())
			dfs(subname, indent, tree.get(name).childs);
	}

	private static class Child {
		public TreeMap<String, Child> childs;

		public Child() {
			this.childs = new TreeMap<String, Child>();
		}
	}
}