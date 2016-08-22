/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.22
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1991
 */

import java.util.Scanner;

public class Main {

	private static Node[] tree;
	private static int numberOfVertices;

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		numberOfVertices = input.nextInt();

		tree = new Node[numberOfVertices];
		for (int index = 0; index < numberOfVertices; index++)
			tree[index] = new Node(getVertex(index));

		for (int count = 0; count < numberOfVertices; count++) {
			char parent = input.next().charAt(0);
			char left = input.next().charAt(0);
			char right = input.next().charAt(0);

			if (left == '.' && right == '.')
				continue;
			if (left == '.') {
				tree[getIndex(parent)].left = null;
				tree[getIndex(parent)].right = tree[getIndex(right)];
			} else if (right == '.') {
				tree[getIndex(parent)].left = tree[getIndex(left)];
				tree[getIndex(parent)].right = null;
			} else {
				tree[getIndex(parent)].left = tree[getIndex(left)];
				tree[getIndex(parent)].right = tree[getIndex(right)];
			}
		}

		preorderPrint(tree[0]);
		System.out.println();
		inorderPrint(tree[0]);
		System.out.println();
		postorderPrint(tree[0]);
		System.out.println();
	}

	public static void preorderPrint(Node tree) {
		if (tree == null)
			return;
		System.out.print(tree.vertex);
		preorderPrint(tree.left);
		preorderPrint(tree.right);
	}

	public static void postorderPrint(Node tree) {
		if (tree == null)
			return;
		postorderPrint(tree.left);
		postorderPrint(tree.right);
		System.out.print(tree.vertex);
	}

	public static void inorderPrint(Node tree) {
		if (tree == null)
			return;
		inorderPrint(tree.left);
		System.out.print(tree.vertex);
		inorderPrint(tree.right);
	}

	private static int getIndex(char vertex) {
		return vertex % 65;
	}

	private static char getVertex(int index) {
		return (char) (index + 65);
	}

	private static class Node {
		public char vertex;
		public Node left;
		public Node right;

		public Node(char vertex) {
			this.vertex = vertex;
			this.left = null;
			this.right = null;
		}
	}
}