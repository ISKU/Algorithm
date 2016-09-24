/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10808
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		String word = new Scanner(System.in).next();
		int[] letters = new int[26];

		for (int index = 0, length = word.length(); index < length; index++)
			letters[word.charAt(index) % 97]++;

		for (int index = 0; index < letters.length; index++)
			System.out.print(letters[index] + " ");
	}
}