/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.08
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1247
 */

import java.util.Scanner;
import java.math.BigInteger;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		for (int testCase = 3; testCase > 0; testCase--) {
			BigInteger sum = new BigInteger("0");

			for (int count = input.nextInt(); count > 0; count--)
				sum = sum.add(new BigInteger(input.next()));

			if (sum.toString().charAt(0) == '0')
				System.out.println(0);
			else if (sum.toString().charAt(0) == '-')
				System.out.println("-");
			else
				System.out.println("+");
		}
	}
}