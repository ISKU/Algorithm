/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.08
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11286
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		PriorityQueue<AbsNode> absHeap = new PriorityQueue<AbsNode>(1000001);

		for (int instructions = Integer.parseInt(input.readLine()); instructions > 0; instructions--) {
			int number = Integer.parseInt(input.readLine());

			if (number == 0)
				output.append(absHeap.isEmpty() ? 0 + "\n" : absHeap.poll().value + "\n");
			else
				absHeap.add(new AbsNode(number, Math.abs(number)));
		}

		System.out.print(output);
	}

	private static class AbsNode implements Comparable<AbsNode> {
		public int value;
		public int absValue;

		public AbsNode(int value, int absValue) {
			this.value = value;
			this.absValue = absValue;
		}

		@Override
		public int compareTo(AbsNode compare) {
			if (this.absValue > compare.absValue)
				return 1;
			else if (this.absValue < compare.absValue)
				return -1;
			else {
				if (this.value > compare.value)
					return 1;
				else if (this.value < compare.value)
					return -1;
				else
					return 0;
			}
		}
	}
}