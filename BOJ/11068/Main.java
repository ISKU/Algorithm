/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.08.10
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11068
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			int n = input.nextInt();

			boolean answer = false;
			for (int b = 2; b <= 64; b++)
				if (isPal(convert(n, b))) {
					answer = true;
					break;
				}

			System.out.println(answer ? "1" : "0");
		}
	}

	private static ArrayList<Integer> convert(int n, int b) {
		ArrayList<Integer> number = new ArrayList<Integer>();
		while (n > 0) {
			number.add(n % b);
			n /= b;
		}
		return number;
	}

	private static boolean isPal(ArrayList<Integer> number) {
		for (int i = 0, j = number.size() - 1; i < j; i++, j--)
			if (number.get(i) != number.get(j))
				return false;
		return true;
	}
}