/*
 * Author: Minho Kim (ISKU)
 * Date: January 27, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2800
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		String[] equ = new Scanner(System.in).next().split("");
		ArrayList<Pair> pairs = new ArrayList<Pair>();
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < equ.length; i++) {
			if ("(".equals(equ[i]))
				stack.add(i);
			if (")".equals(equ[i]))
				pairs.add(new Pair(stack.pop(), i));
		}

		TreeSet<String> answer = new TreeSet<String>();
		int max = (int) Math.pow(2, pairs.size());

		for (int i = 1; i < max; i++) {
			String[] temp = Arrays.copyOf(equ, equ.length);
			String line = "";

			for (int j = i, d = 0; j > 0; j >>>= 1, d++) {
				if ((j & 1) == 1) {
					temp[pairs.get(d).start] = "";
					temp[pairs.get(d).end] = "";
				}
			}

			for (String letter : temp)
				line += letter;
			answer.add(line);
		}

		for (String line : answer)
			System.out.println(line);
	}

	private static class Pair {
		public int start, end;

		public Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}