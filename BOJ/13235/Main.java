/*
 * Author: Minho Kim (ISKU)
 * Date: January 14, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13235
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		char[] word = new Scanner(System.in).next().toCharArray();

		boolean answer = true;
		for (int i = 0, j = word.length - 1; i < j; i++, j--)
			if (word[i] != word[j])
				answer = false;

		System.out.println(answer);
	}
}