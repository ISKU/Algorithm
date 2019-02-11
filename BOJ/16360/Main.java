/*
 * Author: Minho Kim (ISKU)
 * Date: February 11, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16360
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		while (N-- > 0)
			System.out.println(translate(sc.next()));
	}

	private static String translate(String word) {
		char E = word.charAt(word.length() - 1);

		if (E == 'a')
			return word + "s";
		if (E == 'i')
			return word + "os";
		if (E == 'y')
			return word.substring(0, word.length() - 1) + "ios";
		if (E == 'l')
			return word + "es";
		if (E == 'n')
			return word.substring(0, word.length() - 1) + "anes";
		if (E == 'e' && word.charAt(word.length() - 2) == 'n')
			return word.substring(0, word.length() - 2) + "anes";
		if (E == 'o')
			return word + "s";
		if (E == 'r')
			return word + "es";
		if (E == 't')
			return word + "as";
		if (E == 'u')
			return word + "s";
		if (E == 'v')
			return word + "es";
		if (E == 'w')
			return word + "as";

		return word + "us";
	}
}