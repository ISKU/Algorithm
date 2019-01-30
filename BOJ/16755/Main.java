/*
 * Author: Minho Kim (ISKU)
 * Date: January 30, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16755
 */

import java.util.*;

public class Main {

	private static char[] pattern = new char[] { 'H', 'O', 'N', 'I' };

	public static void main(String[] args) {
		char[] line = new Scanner(System.in).next().toCharArray();

		int count = 0;
		int pointer = 0;
		for (int i = 0; i < line.length; i++) {
			if (line[i] == pattern[pointer % 4]) {
				pointer++;
				if (pointer % 4 == 0)
					count++;
			}
		}

		System.out.print(count);
	}
}