/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.11
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2910
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer parser = new StringTokenizer(input.readLine());
		Hashtable<Integer, Node> hashtable = new Hashtable<Integer, Node>(1000);

		int arraySize = Integer.parseInt(parser.nextToken());
		int maxNumber = Integer.parseInt(parser.nextToken());

		parser = new StringTokenizer(input.readLine());
		for (int index = 0; index < arraySize; index++) {
			int number = Integer.parseInt(parser.nextToken());
			hashtable.put(number,
					new Node(number, 
							hashtable.containsKey(number) ? hashtable.get(number).frequency + 1 : 1,
							hashtable.containsKey(number) ? hashtable.get(number).index : index)
			);
		}

		Node[] arrayNode = new Node[hashtable.size()];
		int keyIndex = 0;
		for (Enumeration<Integer> keySet = hashtable.keys(); keySet.hasMoreElements();)
			arrayNode[keyIndex++] = hashtable.get(keySet.nextElement());

		Arrays.sort(arrayNode);

		for (int index = 0; index < arrayNode.length; index++) {
			int number = arrayNode[index].value;
			int frequency = arrayNode[index].frequency;
			for (int count = 0; count < frequency; count++)
				output.append(number + " ");
		}
		System.out.println(output);
	}

	private static class Node implements Comparable<Node> {
		public int value;
		public int frequency;
		public int index;

		public Node(int value, int frequency, int index) {
			this.value = value;
			this.frequency = frequency;
			this.index = index;
		}

		@Override
		public int compareTo(Node compare) {
			if (this.frequency > compare.frequency)
				return -1;
			else if (this.frequency < compare.frequency)
				return 1;
			else {
				if (this.index < compare.index)
					return -1;
				else if (this.index > compare.index)
					return 1;
				else
					return 0;
			}
		}
	}
}