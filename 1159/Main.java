/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.28
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1159
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		char[] names = new char[26];
		int n = input.nextInt();

		while (n-- > 0)
			names[input.next().charAt(0) % 97]++;

		boolean check = true;
		for (int i = 0; i < 26; i++)
			if (names[i] >= 5) {
				System.out.print((char) (i + 97));
				check = false;
			}

		System.out.print(check ? "PREDAJA" : "");
	}
}