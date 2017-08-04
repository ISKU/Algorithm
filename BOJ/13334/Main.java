/* 
 * Author: Minho Kim (ISKU)
 * Date: 2016.10.01
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13334
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		int n = Integer.parseInt(parser.nextToken());

		Line[] line = new Line[n];
		while (n-- > 0) {
			parser = new StringTokenizer(input.readLine());
			int first = Integer.parseInt(parser.nextToken());
			int second = Integer.parseInt(parser.nextToken());
			if (first > second) {
				int temp = first;
				first = second;
				second = temp;
			}
			line[n] = new Line(first, second);
		}

		int L = Integer.parseInt(input.readLine());
		Arrays.sort(line, new Comparator<Line>() {
			@Override
			public int compare(Line A, Line B) {
				return A.o - B.o;
			}
		});

		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
		int answer = 0;
		for (int i = 0; i < line.length; i++) {
			pQueue.add(line[i].h);
			while (!pQueue.isEmpty() && pQueue.peek() < line[i].o - L)
				pQueue.poll();
			answer = Math.max(answer, pQueue.size());
		}

		System.out.print(answer);
	}

	private static class Line {
		public int h;
		public int o;

		public Line(int h, int o) {
			this.h = h;
			this.o = o;
		}
	}
}