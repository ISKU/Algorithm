/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.14
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5218
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			char[] first = input.next().toCharArray();
			char[] second = input.next().toCharArray();

			System.out.print("Distances:");
			for (int i = 0; i < first.length; i++) {
				if (first[i] == second[i])
					System.out.printf(" %d", 0);
				else
					System.out.printf(" %d",
							(first[i] < second[i]) ? (second[i] - first[i]) : (second[i] + 26) - first[i]);
			}
			System.out.println();
		}
	}
}