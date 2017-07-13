/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.06
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2750
 */

import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

		for (int count = input.nextInt(); count > 0; count--)
			minHeap.add(input.nextInt());

		StringBuilder output = new StringBuilder();
		while (!minHeap.isEmpty())
			output.append(minHeap.poll() + "\n");
		System.out.println(output);
	}
}