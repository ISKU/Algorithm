/*
 * Author: Minho Kim (ISKU)
 * Date: May 25, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17254
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Key[] keys = new Key[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			char letter = st.nextToken().charAt(0);
			keys[i] = new Key(index, time, letter);
		}
		Arrays.sort(keys, new Comparator<Key>() {
			@Override
			public int compare(Key o1, Key o2) {
				if (o1.time == o2.time)
					return Integer.compare(o1.index, o2.index);
				return Integer.compare(o1.time, o2.time);
			}
		});

		for (int i = 0; i < M; i++)
			bw.write(keys[i].letter);
		bw.close();
	}

	private static class Key {
		public int index, time;
		public char letter;

		public Key(int index, int time, char letter) {
			this.index = index;
			this.time = time;
			this.letter = letter;
		}
	}
}