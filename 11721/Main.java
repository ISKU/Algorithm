/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.31
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11721
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		String word = input.nextLine();
		int endIndex = word.length() - (word.length() % 10);

		int index = 0;
		while (index < endIndex) {
			System.out.println(word.substring(index, index + 10));
			index = index + 10;
		}
		System.out.println(word.substring(index, index + word.length() % 10)); // final word
	}
}