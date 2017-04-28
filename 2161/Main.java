/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.28
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2161
 */

import java.util.Scanner;
import java.util.LinkedList;

public class Main {
	public static void main(String... args) {
		int last = new Scanner(System.in).nextInt();
		LinkedList<Integer> card = new LinkedList<Integer>();

		for (int i = 1; i <= last; i++)
			card.add(i);

		while (card.size() != 1) {
			System.out.printf("%d ", card.poll());
			card.add(card.poll());
		}

		System.out.print(card.poll());
	}
}