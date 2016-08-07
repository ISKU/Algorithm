/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.07
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1927
 */

import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

		for (int instructions = input.nextInt(); instructions > 0; instructions--) {
			int number = input.nextInt();
			if (number == 0)
				System.out.println(minHeap.isEmpty() ? 0 : minHeap.poll());
			else
				minHeap.add(number);
		}
	}
}