/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.04.30
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/12174
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		for (int tCase = 1; tCase <= testCase; tCase++) {
			int B = input.nextInt();
			String word = input.next().replaceAll("O", "0").replaceAll("I", "1");

			System.out.printf("Case #%d: ", tCase);
			for (int i = 1; i <= B; i++)
				System.out.print((char) Integer.parseInt(word.substring(8 * i - 8, 8 * i), 2));
			System.out.println();
		}
	}
}