/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.16
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10825
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {

	private static int N, M;
	private static int min = Integer.MAX_VALUE;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int count = input.nextInt();
		Node[] array = new Node[count];

		for (int i = 0; i < count; i++)
			array[i] = new Node(input.next(), input.nextInt(), input.nextInt(), input.nextInt());

		Arrays.sort(array);
		for (int i = 0; i < count; i++)
			System.out.println(array[i].name);
	}

	private static class Node implements Comparable<Node> {
		public String name;
		public int guk;
		public int young;
		public int su;

		public Node(String name, int guk, int young, int su) {
			this.name = name;
			this.guk = guk;
			this.young = young;
			this.su = su;
		}

		@Override
		public int compareTo(Node o) {
			if (this.guk < o.guk)
				return 1;
			else if (this.guk > o.guk)
				return -1;
			else {
				if (this.young < o.young)
					return -1;
				else if (this.young > o.young)
					return 1;
				else {
					if (this.su < o.su)
						return 1;
					else if (this.su > o.su)
						return -1;
					else
						return this.name.compareTo(o.name);
				}
			}
		}
	}
}