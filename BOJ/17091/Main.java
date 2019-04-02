/*
 * Author: Minho Kim (ISKU)
 * Date: April 1, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17091
 */

import java.util.*;

public class Main {

	public static final String[] number = new String[] { "o' clock", "one", "two", "three", "four", "five", "six",
			"seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen",
			"seventeen", "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four",
			"twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine", "half" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();

		if (M == 0)
			System.out.printf("%s %s\n", number[H], number[0]);
		else if (M == 1)
			System.out.printf("%s minute past %s\n", number[M], number[H]);
		else if (M <= 14)
			System.out.printf("%s minutes past %s\n", number[M], number[H]);
		else if (M == 15)
			System.out.printf("%s past %s\n", number[M], number[H]);
		else if (M <= 29)
			System.out.printf("%s minutes past %s\n", number[M], number[H]);
		else if (M == 30)
			System.out.printf("%s past %s\n", number[M], number[H]);
		else if (M <= 44)
			System.out.printf("%s minutes to %s\n", number[60 - M], number[H + 1]);
		else if (M == 45)
			System.out.printf("%s to %s\n", number[60 - M], number[H + 1]);
		else if (M <= 58)
			System.out.printf("%s minutes to %s\n", number[60 - M], number[H + 1]);
		else
			System.out.printf("%s minute to %s\n", number[60 - M], number[H + 1]);
	}
}