/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13116
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		for (int testCase = input.nextInt(); testCase > 0; testCase--) {
			int[] tree = new int[1024];
			int nodeA = input.nextInt();
			int nodeB = input.nextInt();

			do {
				if (nodeA >= 1)
					tree[nodeA]++;
				if (nodeB >= 1)
					tree[nodeB]++;

				if (nodeA >= 1 && tree[nodeA] >= 2) {
					System.out.println(nodeA * 10);
					break;
				}
				if (nodeB >= 1 && tree[nodeB] >= 2) {
					System.out.println(nodeB * 10);
					break;
				}

				nodeA = nodeA / 2;
				nodeB = nodeB / 2;
			} while (true);
		}
	}
}