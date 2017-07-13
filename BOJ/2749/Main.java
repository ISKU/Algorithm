/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.12
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2749
 */

import java.util.Scanner;
import java.math.BigInteger;

public class Main {

	private static final BigInteger pisanoPeriod = new BigInteger("1500000"); // 15*10^(n-1), n=6(10^6)
	private static final BigInteger DIVISOR = new BigInteger("1000000");

	public static void main(String args[]) {
		BigInteger inputNumber = new BigInteger(new Scanner(System.in).next());
		BigInteger first = new BigInteger("0");
		BigInteger second = new BigInteger("1");
		BigInteger fibonacciNumber = new BigInteger("1");

		for (int count = 1; count < Integer.parseInt(inputNumber.remainder(pisanoPeriod).toString()); count++) {
			fibonacciNumber = first.add(second);
			first = second.remainder(DIVISOR);
			second = fibonacciNumber.remainder(DIVISOR);
		}
		System.out.println(fibonacciNumber.remainder(DIVISOR));
	}
}