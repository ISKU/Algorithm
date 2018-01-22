/*
 * Author: Minho Kim (ISKU)
 * Date: January 22, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4673
 */

public class Main {
	public static void main(String... args) {
		boolean[] self = new boolean[10001];

		for (int i = 1; i <= 10000; i++) {
			int sum = i;
			for (String digit : String.valueOf(i).split(""))
				sum += Integer.parseInt(digit);
			if (sum <= 10000)
				self[sum] = true;
		}

		for (int i = 1; i <= 10000; i++)
			if (!self[i])
				System.out.println(i);
	}
}