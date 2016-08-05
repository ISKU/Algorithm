/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.05
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10818
 */

import java.util.Scanner;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

		for (int count = input.nextInt() - 1; count >= 0; count--) {
			int number = input.nextInt();
			minHeap.add(number);
			maxHeap.add(number);
		}

		System.out.println(minHeap.poll());
		System.out.println(maxHeap.poll());
	}
}