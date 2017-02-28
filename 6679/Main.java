/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.01
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/6679
 */

public class Main {
	public static void main(String... args) {
		for (int i = 2992; i < 10000; i++) {
			int first = get(i, 10);
			int second = get(i, 12);
			int third = get(i, 16);

			if (first == second && second == third && first == third)
				System.out.println(i);
		}
	}

	private static int get(int num, int digit) {
		int i = 1;
		int result = 0;

		while (i <= num)
			i *= digit;

		i /= digit;
		while (num != 0) {
			result += num / i;
			num %= i;
			i /= digit;
		}

		return result;
	}
}