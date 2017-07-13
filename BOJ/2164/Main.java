/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.01
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2164
 */

import java.util.Scanner;
import java.util.LinkedList;

public class Main {
	public static void main(String... args) {
		int N = new Scanner(System.in).nextInt();
		LinkedList<Integer> list = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++)
			list.add(i);

		while (list.size() != 1) {
			list.poll();
			list.add(list.poll());
		}

		System.out.print(list.get(0));
	}
}