/*
 * Author: Minho Kim (ISKU)
 * Date: May 26, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4358
 */

import java.io.*;

public class Main {

	private static BufferedReader br;
	private static BufferedWriter bw;
	private static int total;
	private static char[] buffer;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Node trie = new Node();
		String line = null;
		while ((line = br.readLine()) != null) {
			insert(line, trie);
			total++;
		}

		buffer = new char[31];
		print(0, trie);
		bw.close();
	}

	private static void print(int n, Node p) throws Exception {
		if (p.count >= 1) {
			bw.write(buffer, 0, n);
			bw.write(String.format(" %.4f\n", p.count * 100 / total));
		}

		for (int c = 0; c < 96; c++) {
			if (p.letter[c] == null)
				continue;

			buffer[n] = (char) (c + 32);
			print(n + 1, p.letter[c]);
		}
	}

	private static void insert(String S, Node p) {
		for (int i = 0; i < S.length(); i++) {
			int c = S.charAt(i) - 32;
			if (p.letter[c] == null)
				p.letter[c] = new Node();

			p = p.letter[c];
		}

		p.count++;
	}

	private static class Node {
		public Node[] letter;
		public double count;

		public Node() {
			this.letter = new Node[96];
		}
	}
}