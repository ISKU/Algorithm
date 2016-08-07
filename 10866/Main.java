/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.07
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10866
 */

import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		LinkedBlockingDeque<Integer> deque = new LinkedBlockingDeque<Integer>();

		for (int commandNumber = input.nextInt(); commandNumber >= 0; commandNumber--) {
			String[] command = input.nextLine().split(" ");

			switch (command[0]) {
			case "push_front":
				deque.addFirst(Integer.parseInt(command[1]));
				break;
			case "push_back":
				deque.addLast(Integer.parseInt(command[1]));
				break;
			case "pop_front":
				System.out.println(deque.isEmpty() ? -1 : deque.pollFirst());
				break;
			case "pop_back":
				System.out.println(deque.isEmpty() ? -1 : deque.pollLast());
				break;
			case "front":
				System.out.println(deque.isEmpty() ? -1 : deque.getFirst());
				break;
			case "back":
				System.out.println(deque.isEmpty() ? -1 : deque.getLast());
				break;
			case "empty":
				System.out.println(deque.isEmpty() ? 1 : 0);
				break;
			case "size":
				System.out.println(deque.isEmpty() ? 0 : deque.size());
				break;
			default:
				break;
			}
		}
	}
}