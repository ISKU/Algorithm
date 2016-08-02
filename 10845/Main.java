/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.02
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10845
 */

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<Integer>();
		int lastNumberInQueue = -1;

		for (int commandNumber = input.nextInt(); commandNumber >= 0; commandNumber--) {
			String[] command = input.nextLine().split(" ");

			switch (command[0]) {
			case "push":
				queue.add(Integer.parseInt(command[1]));
				lastNumberInQueue = Integer.parseInt(command[1]);
				break;
			case "pop":
				System.out.println(queue.isEmpty() ? -1 : queue.poll());
				break;
			case "front":
				System.out.println(queue.isEmpty() ? -1 : queue.peek());
				break;
			case "back":
				System.out.println(queue.isEmpty() ? -1 : lastNumberInQueue);
				break;
			case "size":
				System.out.println(queue.size());
				break;
			case "empty":
				System.out.println(queue.isEmpty() ? 1 : 0);
				break;
			default:
				break;
			}
		}
	}
}