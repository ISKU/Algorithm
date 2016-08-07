/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.07
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/3058
 */

import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		for (int testCase = input.nextInt(); testCase > 0; testCase--) {
			PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
			int sum, minimumNumber;

			for (int index = 0; index < 7; index++) {
				int number = input.nextInt();
				if (number % 2 == 0)
					minHeap.add(number);
			}

			sum = minimumNumber = minHeap.poll();
			while (!minHeap.isEmpty())
				sum += minHeap.poll();

			System.out.println(sum + " " + minimumNumber);
		}
	}
}