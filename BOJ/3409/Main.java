/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.11.19
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/3409
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class Main {

	private static Hashtable<String, Integer> table;
	private static Node[] node;
	private static boolean[] visited;
	private static String target;
	private static int idx;

	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(input.readLine());

		while (testCase-- > 0) {
			int equations = Integer.parseInt(input.readLine());
			int id = 0;
			table = new Hashtable<String, Integer>(500);
			node = new Node[503];

			while (equations-- > 0) {
				String[] equation = input.readLine().split(" = ");
				String[] variable = equation[1].split(" [+] ");
				table.put(equation[0], table.containsKey(equation[0]) ? table.get(equation[0]) : ++id);

				if (variable.length == 1)
					node[table.get(equation[0])] = new Node(-1, -1, 0, variable[0]);
				else {
					table.put(variable[0], table.containsKey(variable[0]) ? table.get(variable[0]) : ++id);
					table.put(variable[1], table.containsKey(variable[1]) ? table.get(variable[1]) : ++id);
					node[table.get(equation[0])] = new Node(table.get(variable[0]), table.get(variable[1]), 0, null);
				}
			}

			String start = input.readLine();
			visited = new boolean[++id];
			build(table.get(start));

			idx = 0;
			target = input.readLine();
			findTarget(table.get(start));

			System.out.println(target.length() == idx ? "YES" : "NO");
		}
	}

	private static void build(int id) {
		if (!visited[id]) {
			visited[id] = true;

			if (node[id].word != null) {
				for (int index = 0, length = node[id].word.length(); index < length; index++)
					node[id].has |= 1 << (node[id].word.charAt(index) - 'a');
				return;
			}

			build(node[id].left);
			build(node[id].right);
			node[id].has = node[node[id].left].has | node[node[id].right].has;
		}
	}

	private static void findTarget(int id) {
		if (target.length() == idx || (node[id].has & (1 << (target.charAt(idx) - 'a'))) == 0)
			return;

		if (node[id].word != null) {
			for (int index = 0, length = node[id].word.length(); index < length && target.length() != idx; index++)
				idx += (target.charAt(idx) == node[id].word.charAt(index)) ? 1 : 0;
			return;
		}

		findTarget(node[id].left);
		findTarget(node[id].right);
	}

	private static class Node {
		public int left;
		public int right;
		public int has;
		public String word;

		public Node(int left, int right, int has, String word) {
			this.left = left;
			this.right = right;
			this.has = has;
			this.word = word;
		}
	}
}