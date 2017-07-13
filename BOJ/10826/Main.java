/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.11
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10826
 */

import java.util.Scanner;
import java.math.BigInteger;

public class Main {
	public static void main(String args[]) {
		BigInteger[] fibonacciSequence = new BigInteger[10001];
		fibonacciSequence[0] = new BigInteger("0");
		fibonacciSequence[1] = new BigInteger("1");
		fibonacciSequence[2] = new BigInteger("1");

		for (int index = 3; index < fibonacciSequence.length; index++)
			fibonacciSequence[index] = fibonacciSequence[index - 1].add(fibonacciSequence[index - 2]);

		System.out.println(fibonacciSequence[new Scanner(System.in).nextInt()].toString());
	}
}