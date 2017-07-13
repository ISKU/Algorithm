/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.14
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/3062
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = Integer.parseInt(input.nextLine());

		while (testCase-- > 0) {
			String number = input.nextLine();
			String reverse = new StringBuilder(number).reverse().toString();
			String sum = String.valueOf(Integer.parseInt(number.toString()) + Integer.parseInt(reverse.toString()));
			boolean check = false;

			for (int i = 0, j = sum.length() - 1; i < j; i++, j--) {
				if (sum.charAt(i) != sum.charAt(j)) {
					check = true;
					break;
				}
			}

			System.out.println(check ? "NO" : "YES");
		}
	}
}