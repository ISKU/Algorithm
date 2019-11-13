/*
 * Author: Minho Kim (ISKU)
 * Date: November 13, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1918
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] line = br.readLine().toCharArray();

		Stack<Character> stack = new Stack<>();
		for (char c : line) {
			if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(')
					System.out.print(stack.pop());
				stack.pop();
			} else if (c == '*' || c == '/') {
				while (!stack.isEmpty() && getPriority(stack.peek()) >= 3)
					System.out.print(stack.pop());
				stack.push(c);
			} else if (c == '+' || c == '-') {
				while (!stack.isEmpty() && getPriority(stack.peek()) >= 2)
					System.out.print(stack.pop());
				stack.push(c);
			} else {
				System.out.print(c);
			}
		}
		while (!stack.isEmpty())
			System.out.print(stack.pop());
	}

	private static int getPriority(char c) {
		switch (c) {
		case '*':
		case '/':
			return 3;
		case '+':
		case '-':
			return 2;
		default:
			return 1;
		}
	}
}
