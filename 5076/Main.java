/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.28
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5076
 */

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			Stack<String> stack = new Stack<String>();
			StringBuilder openingTag = new StringBuilder();
			StringBuilder closingTag = new StringBuilder();
			String[] code = input.nextLine().split("");
			String previous = null;
			boolean checkOpeningTag = false;
			boolean checkClosingTag = false;
			boolean checkLegal = true;
			boolean limitTag = true;

			if (code[0].equals("#"))
				break;

			for (int index = 0; index < code.length; index++) {
				if (index != 0)
					previous = code[index - 1];

				if (code[index].equals("<")) {
					checkOpeningTag = true;
					continue;
				}

				if (code[index].equals(">")) {
					if (checkOpeningTag) {
						limitTag = true;
						checkOpeningTag = false;
						if (previous.equals("/")) {
							openingTag = new StringBuilder();
							continue;
						}
						stack.push(openingTag.toString());
						openingTag = new StringBuilder();
					}
					if (checkClosingTag) {
						checkClosingTag = false;
						if (stack.isEmpty() || !(stack.pop()).equals(closingTag.toString())) {
							checkLegal = false;
							stack = new Stack();
							break;
						}
						closingTag = new StringBuilder();
					}

					continue;
				}

				if (checkOpeningTag && code[index].equals("/") && openingTag.length() == 0) {
					checkOpeningTag = false;
					checkClosingTag = true;
					continue;
				}

				if (checkOpeningTag && limitTag) {
					if (code[index].equals(" ")) {
						limitTag = false;
						continue;
					}

					openingTag.append(code[index]);
				}

				if (checkClosingTag)
					closingTag.append(code[index]);
			}

			System.out.println(checkLegal && stack.isEmpty() ? "legal" : "illegal");
		}
	}
}