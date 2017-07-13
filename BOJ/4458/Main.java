/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.03
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4458
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int numberOfLines = input.nextInt();

		for (input.nextLine(); numberOfLines > 0; numberOfLines--) {
			String sentence = input.nextLine();
			System.out.println(sentence.substring(0, 1).toUpperCase() + sentence.substring(1, sentence.length()));
		}
	}
}