/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.05.21
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4949
 */

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			Stack<Character> stack = new Stack<Character>();
			char[] sentence = input.nextLine().toCharArray();

			if (sentence[0] == '.')
				break;

			OUT: 
			for (int i = 0; i < sentence.length; i++) {
				switch (sentence[i]) {
				case '[':
					stack.push(sentence[i]);
					break;
				case ']':
					if (stack.isEmpty() || stack.peek() != '[') {
						stack.push(sentence[i]);
						break OUT;
					}
					stack.pop();
					break;
				case '(':
					stack.push(sentence[i]);
					break;
				case ')':
					if (stack.isEmpty() || stack.peek() != '(') {
						stack.push(sentence[i]);
						break OUT;
					}
					stack.pop();
					break;
				default:
					continue;
				}
			}

			System.out.println(stack.isEmpty() ? "yes" : "no");
		}
	}
}