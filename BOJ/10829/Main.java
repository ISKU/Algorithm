/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.24
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10829
 */

import java.util.Scanner;
import java.math.BigInteger;

public class Main {

	private static final BigInteger ZERO = new BigInteger("0");
	private static final BigInteger TWO = new BigInteger("2");

	public static void main(String args[]) {
		BigInteger number = new BigInteger(new Scanner(System.in).next());
		StringBuilder output = new StringBuilder();

		while (!number.equals(ZERO)) {
			output.append(number.remainder(TWO));
			number = number.divide(TWO);
		}

		System.out.print(output.reverse());
	}
}