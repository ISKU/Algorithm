/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.07
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1252
 */

import java.util.Scanner;
import java.math.BigInteger;

public class Main {

	private static BigInteger ZERO = BigInteger.ZERO;
	private static BigInteger TWO = new BigInteger("2");

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BigInteger sum = BigInteger.ZERO;
		char[] first = input.next().toCharArray();
		char[] second = input.next().toCharArray();

		for (int i = first.length - 1, j = 0; i >= 0; i--, j++)
			if (first[i] == '1')
				sum = sum.add(BigInteger.valueOf(2).pow(j));

		for (int i = second.length - 1, j = 0; i >= 0; i--, j++)
			if (second[i] == '1')
				sum = sum.add(BigInteger.valueOf(2).pow(j));

		StringBuilder output = new StringBuilder(sum.equals(ZERO) ? "0" : "");
		while (!sum.equals(ZERO)) {
			output.insert(0, sum.remainder(TWO));
			sum = sum.divide(TWO);
		}

		System.out.print(output);
	}
}