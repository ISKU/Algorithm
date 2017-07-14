/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.04.10
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/796/A
 */

import java.util.*;
import java.io.*;
import java.math.*;

public class A {
	public static void main(String... args) throws IOException {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt() - 1;
		int k = input.nextInt();

		Node[] array = new Node[n];
		for (int i = 0; i < n; i++)
			array[i] = new Node(i, input.nextInt());

		ArrayList<Node> left = new ArrayList<Node>();
		for (int i = m - 1; i >= 0; i--)
			if (array[i].value != 0 && array[i].value <= k)
				left.add(array[i]);

		ArrayList<Node> right = new ArrayList<Node>();
		for (int i = m + 1; i < n; i++)
			if (array[i].value != 0 && array[i].value <= k)
				right.add(array[i]);

		Collections.sort(left, (a, b) -> {
			if (a.index < b.index)
				return 1;
			else if (a.index > b.index)
				return -1;
			else
				return 0;
		});

		Collections.sort(right, (a, b) -> {
			if (a.index < b.index)
				return -1;
			else if (a.index > b.index)
				return 1;
			else
				return 0;
		});

		int candLeft = left.isEmpty() ? Integer.MAX_VALUE : (m * 10) - (left.get(0).index * 10);
		int candRight = right.isEmpty() ? Integer.MAX_VALUE : (right.get(0).index * 10) - (m * 10);
		System.out.print(candLeft > candRight ? candRight : candLeft);
	}

	private static class Node {
		public int index;
		public int value;

		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
}