/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.08.06
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1251
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		String word = new Scanner(System.in).next();
		ArrayList<String> answer = new ArrayList<String>();

		for (int i = 1; i < word.length() - 1; i++)
			for (int j = i + 1; j < word.length(); j++)
				answer.add(find(word.substring(0, i), word.substring(i, j), word.substring(j, word.length())));

		Collections.sort(answer);
		System.out.print(answer.get(0));
	}

	private static String find(String A, String B, String C) {
		StringBuilder result = new StringBuilder();

		for (int i = A.length() - 1; i >= 0; i--)
			result.append(A.charAt(i));
		for (int i = B.length() - 1; i >= 0; i--)
			result.append(B.charAt(i));
		for (int i = C.length() - 1; i >= 0; i--)
			result.append(C.charAt(i));

		return result.toString();
	}
}