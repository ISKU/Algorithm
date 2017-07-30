/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.30
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1010
 */

import java.util.*;
import java.math.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0)
			System.out.println(combination(input.nextInt(), input.nextInt()));
	}

	private static BigInteger combination(int N, int M) {
		BigInteger ret = BigInteger.ONE;

		for (int i = M; i > M - N; i--)
			ret = ret.multiply(BigInteger.valueOf(i));
		for (int i = N; i > 0; i--)
			ret = ret.divide(BigInteger.valueOf(i));

		return ret;
	}
}