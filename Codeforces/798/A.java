/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.04.21
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/798/A
 */

import java.util.*;
import java.io.*;
import java.math.*;

public class A {
	public static void main(String... args) throws IOException {
		Scanner input = new Scanner(System.in);

		String[] string = input.next().split("");
		Node ans = isPalindrome(string);

		if (string.length == 1)
			System.out.print("YES");
		else if (string.length % 2 == 1 && ans.i == -1)
			System.out.print("YES");
		else if (ans.i == -1)
			System.out.print("NO");
		else {
			string[ans.i] = string[ans.j];
			Node first = isPalindrome(string);

			if (first.i == -1)
				System.out.print("YES");
			else
				System.out.print("NO");
		}
	}

	private static Node isPalindrome(String[] string) {
		for (int i = 0, j = string.length - 1; i < j; i++, j--) {
			if (!string[i].equals(string[j]))
				return new Node(i, j);
		}

		return new Node(-1, -1);
	}

	private static class Node {
		public int i;
		public int j;

		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}