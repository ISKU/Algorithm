/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.23
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1374
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	public static void main(String... args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(parser.nextToken());
		Node[] array = new Node[N * 2];

		for (int i = 0; i < N; i++) {
			parser = new StringTokenizer(input.readLine());
			parser.nextToken();
			array[i] = new Node(Integer.parseInt(parser.nextToken()), 1);
			array[N + i] = new Node(Integer.parseInt(parser.nextToken()), -1);
		}

		Arrays.sort(array);
		int max = 0;
		for (int i = 0, sum = 0; i < array.length; i++) {
			sum += array[i].second;
			max = Math.max(max, sum);
		}

		System.out.println(max);
	}

	private static class Node implements Comparable<Node> {
		public int first;
		public int second;

		public Node(int start, int end) {
			this.first = start;
			this.second = end;
		}

		@Override
		public int compareTo(Node o) {
			if (this.first < o.first)
				return -1;
			else if (this.first > o.first)
				return 1;
			else {
				if (this.second < o.second)
					return -1;
				else if (this.second > o.second)
					return 1;
				else
					return 0;
			}
		}
	}
}