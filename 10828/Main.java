/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.02
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10828
 */

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();

		for (int commandNumber = input.nextInt(); commandNumber >= 0; commandNumber--) {
			String[] command = input.nextLine().split(" ");

			switch (command[0]) {
			case "push":
				stack.push(Integer.parseInt(command[1]));
				break;
			case "pop":
				System.out.println(stack.isEmpty() ? -1 : stack.pop());
				break;
			case "top":
				System.out.println(stack.isEmpty() ? -1 : stack.peek());
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				System.out.println(stack.isEmpty() ? 1 : 0);
				break;
			default:
				break;
			}
		}
	}
}