/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.24
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5397
 */

import java.util.Scanner;
import java.util.LinkedList;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			LinkedList<Character> passwd = new LinkedList<Character>();
			int pointer = 0;
			char[] command = input.next().toCharArray();

			for (int i = 0; i < command.length; i++) {
				if (command[i] == '<')
					pointer = (pointer <= 0) ? 0 : pointer - 1;
				else if (command[i] == '>')
					pointer = (pointer >= passwd.size()) ? passwd.size() : pointer + 1;
				else if (command[i] == '-') {
					if (!passwd.isEmpty() && pointer != 0)
						passwd.remove(--pointer);
				} else
					passwd.add(pointer++, command[i]);
			}

			StringBuilder output = new StringBuilder();
			for (char letter : passwd)
				output.append(letter);
			System.out.println(output);
		}
	}
}