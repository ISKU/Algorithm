/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/6068
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		Node[] table = new Node[Integer.parseInt(parser.nextToken())];

		for (int index = 0; index < table.length; index++) {
			parser = new StringTokenizer(input.readLine());
			table[index] = new Node(Integer.parseInt(parser.nextToken()), Integer.parseInt(parser.nextToken()));
		}
		Arrays.sort(table);

		int sum = table[0].end - table[0].time;
		int breakCount = sum;
		boolean complete = true;

		for (int index = 0; index < table.length; index++) {
			sum += table[index].time;

			if (breakCount <= 0) {
				complete = false;
				break;
			}

			if (sum > table[index].end) {
				sum = --breakCount;
				index = -1;
			}
		}

		System.out.print(complete ? breakCount : -1);
	}

	private static class Node implements Comparable<Node> {
		public int time;
		public int end;

		public Node(int time, int end) {
			this.time = time;
			this.end = end;
		}

		@Override
		public int compareTo(Node compare) {
			if (this.end > compare.end)
				return 1;
			else if (this.end < compare.end)
				return -1;
			else
				return 0;
		}
	}
}