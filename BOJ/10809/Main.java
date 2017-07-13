/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.24
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10809
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		String word = new Scanner(System.in).next();
		int[] indexOfLetter = new int[26];

		for (int index = 0; index < indexOfLetter.length; index++)
			indexOfLetter[index] = -1;

		for (int index = 0, length = word.length(); index < length; index++)
			if (indexOfLetter[word.charAt(index) % 97] == -1)
				indexOfLetter[word.charAt(index) % 97] = index;

		for (int index = 0; index < indexOfLetter.length; index++)
			System.out.print(indexOfLetter[index] + " ");
	}
}