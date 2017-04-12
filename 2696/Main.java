/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.13
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2696
 */

import java.util.Scanner;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			ArrayList<Integer> answer = new ArrayList<Integer>();
			PriorityQueue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());
			PriorityQueue<Integer> min = new PriorityQueue<Integer>();
			int M = input.nextInt() / 2;
			int mid = input.nextInt();
			answer.add(mid);

			while (M-- > 0) {
				int first = input.nextInt();
				int second = input.nextInt();

				max.add((first <= mid) ? first : mid);
				min.add((first <= mid) ? mid : first);

				if (second <= min.peek()) {
					max.add(second);
					mid = max.poll();
				} else {
					min.add(second);
					mid = min.poll();
				}

				answer.add(mid);
			}

			System.out.println(answer.size());
			for (int i = 0; i < answer.size(); i++)
				System.out.printf("%d%s", answer.get(i), i % 10 == 9 ? "\n" : " ");
			System.out.println();
		}
	}
}