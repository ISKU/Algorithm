/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.23
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9946
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		for (int testCase = 1;; testCase++) {
			String first = input.next();
			String second = input.next();

			if (first.equals("END") && second.equals("END"))
				break;

			String[] firstWord = first.split("");
			String[] secondWord = second.split("");
			Arrays.sort(firstWord);
			Arrays.sort(secondWord);

			if (firstWord.length != secondWord.length) {
				System.out.printf("Case %d: different\n", testCase);
				continue;
			}

			boolean check = false;
			for (int i = 0; i < firstWord.length; i++)
				if (!firstWord[i].equals(secondWord[i])) {
					check = true;
					break;
				}

			System.out.printf("Case %d: %s\n", testCase, check ? "different" : "same");
		}
	}
}