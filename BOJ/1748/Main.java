/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.08.10
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1748
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int[] digit = new int[] { 0, 9, 90, 900, 9000, 90000, 900000, 9000000, 90000000 };
		String N = input.next();

		long sum = 0;
		for (int i = 1; i < N.length(); i++)
			sum += digit[i] * i;
		sum += (Integer.parseInt(N) - (int) Math.pow(10, N.length() - 1) + 1) * N.length();
		
		System.out.print(sum);
	}
}