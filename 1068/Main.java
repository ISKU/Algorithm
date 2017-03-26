/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.26
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1068
 */

import java.util.Scanner;

public class Main {

	private static int count = 0;

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Node[] tree = new Node[input.nextInt()];

		for (int i = 0; i < tree.length; i++)
			tree[i] = new Node(i);

		int root = -1;
		for (int i = 0; i < tree.length; i++) {
			int parent = input.nextInt();
			tree[i].parent = parent;

			if (parent == -1)
				root = i;
			else {
				if (tree[parent].left == null)
					tree[parent].left = tree[i];
				else
					tree[parent].right = tree[i];
			}
		}

		int remove = input.nextInt();

		if (tree[remove].parent == -1)
			tree[remove] = null;
		else if (tree[tree[remove].parent].left != null && tree[tree[remove].parent].left.index == remove)
			tree[tree[remove].parent].left = null;
		else if (tree[tree[remove].parent].right != null && tree[tree[remove].parent].right.index == remove)
			tree[tree[remove].parent].right = null;

		if (tree[root] == null)
			System.out.print(0);
		else if (tree[root].left == null && tree[root].right == null)
			System.out.print(1);
		else {
			prefix(tree[root]);
			System.out.print(count);
		}
	}

	private static void prefix(Node node) {
		if (node.left == null && node.right == null) {
			count++;
			return;
		}

		if (node.left != null)
			prefix(node.left);
		if (node.right != null)
			prefix(node.right);
	}

	private static class Node {
		public int index;
		public int parent;
		public Node left;
		public Node right;

		public Node(int index) {
			this.index = index;
		}
	}
}