/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.23
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2407
 */

import java.util.Scanner;
import java.math.BigInteger;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		System.out.print(combination(input.nextInt(), input.nextInt()));
	}

	private static BigInteger combination(int n, int k) {
		BigInteger result = BigInteger.ONE;
		for (int i = 0; i < k; i++)
			result = result.multiply(BigInteger.valueOf(n - i)).divide(BigInteger.valueOf(i + 1));
		return result;
	}
}