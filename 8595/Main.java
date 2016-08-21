/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.21
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/8595
 */

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		int length = input.nextInt();
		String string = input.next();
		long sum = 0;

		for (int index = 0; index < length; index++) {
			char currentCharacter = string.charAt(index);

			if (currentCharacter >= 48 && currentCharacter <= 57) {
				if (stack.isEmpty())
					stack.push(Character.getNumericValue(currentCharacter));
				else {
					int previousNumber = stack.pop() * 10;
					stack.push(previousNumber + Character.getNumericValue(currentCharacter));
				}
			} else {
				if (stack.isEmpty())
					continue;
				else
					sum += stack.pop();
			}
		}

		System.out.print(stack.isEmpty() ? sum : stack.pop() + sum);
	}
}