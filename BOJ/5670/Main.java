/*
 * Author: Minho Kim (ISKU)
 * Date: May 26, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5670
 */

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = null;
		while ((line = br.readLine()) != null) {
			Node trie = new Node();

			int N = Integer.parseInt(line);
			String[] words = new String[N];
			for (int i = 0; i < N; i++) {
				words[i] = br.readLine();
				insert(words[i], trie);
			}

			double sum = 0;
			for (int i = 0; i < N; i++) {
				int c = words[i].charAt(0) - 'a';
				sum += search(words[i], trie.letter[c]);
			}

			bw.write(String.format("%.2f\n", sum / N));
		}

		bw.close();
	}

	private static int search(String S, Node p) {
		int count = 1;

		for (int i = 1; i < S.length(); i++) {
			if (p.next > 1 || p.end)
				count++;

			int c = S.charAt(i) - 'a';
			p = p.letter[c];
		}

		return count;
	}

	private static void insert(String S, Node p) {
		for (int i = 0; i < S.length(); i++) {
			int c = S.charAt(i) - 'a';
			if (p.letter[c] == null) {
				p.next++;
				p.letter[c] = new Node();
			}

			p = p.letter[c];
		}

		p.end = true;
	}

	private static class Node {
		public Node[] letter;
		public int next;
		public boolean end;

		public Node() {
			letter = new Node[26];
		}
	}
}