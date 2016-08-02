/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.02
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9012
 */

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		for (int testCase = input.nextInt(); testCase > 0; testCase--) {
			Stack<String> stack = new Stack<String>();
			String[] bracket = input.next().split("");

			for (int count = 0; count < bracket.length; count++) {
				if (bracket[count].equals("("))
					stack.push(bracket[count]);
				else {
					if (stack.isEmpty()) {
						stack.push("No VPS");
						break;
					}
					stack.pop();
				}
			}

			System.out.println(stack.isEmpty() ? "YES" : "NO");
		}
	}
}