/*
 * Author: Minho Kim (ISKU)
 * Date: May 26, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5052
 */

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			Node trie = new Node();
			boolean check = true;

			int N = Integer.parseInt(br.readLine());
			while (N-- > 0) {
				String number = br.readLine();
				if (check && !insert(0, number, trie))
					check = false;
			}

			bw.write((check) ? "YES\n" : "NO\n");
		}

		bw.close();
	}

	private static boolean insert(int i, String S, Node p) {
		if (i == S.length()) {
			p.end = true;
			return !p.next;
		}
		if (p.end)
			return false;

		int c = S.charAt(i) - '0';
		if (p.letter[c] == null) {
			p.next = true;
			p.letter[c] = new Node();
		}
		return insert(i + 1, S, p.letter[c]);
	}

	private static class Node {
		public Node[] letter;
		public boolean end, next;

		public Node() {
			letter = new Node[10];
		}
	}
}