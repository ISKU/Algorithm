/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.06.30
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.codeground.org/
 */

import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
	public static void main(String... args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(input.readLine());

		for (int tCase = 1; tCase <= testCase; tCase++) {
			Stack<Bracket> stack = new Stack<Bracket>();
			char[] line = input.readLine().toCharArray();
			boolean[] check = new boolean[line.length];

			for (int i = 0; i < line.length; i++) {
				if (!stack.isEmpty()
					&& ((line[i] == ')' && stack.peek().value == '(')
					|| (line[i] == ']' && stack.peek().value == '[') 
					|| (line[i] == '}' && stack.peek().value == '{'))) 
				{
					check[stack.pop().index] = true;
					check[i] = true;
					continue;
				}

				stack.push(new Bracket(i, line[i]));
			}

			int answer = 0;
			for (int i = 0, temp = 0; i < check.length; i++) {
				temp = (check[i]) ? temp + 1 : 0;
				answer = Math.max(answer, temp);
			}

			output.write(String.format("Case #%d\n%d\n", tCase, answer));
		}

		output.close();
	}

	private static class Bracket {
		public int index;
		public char value;

		public Bracket(int index, char value) {
			this.index = index;
			this.value = value;
		}
	}
}