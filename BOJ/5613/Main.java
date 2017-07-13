/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.24
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5613
 */

import java.util.Scanner;
import java.math.BigInteger;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		BigInteger result = new BigInteger(input.nextLine());

		while (true) {
			String line = input.nextLine();

			switch (line) {
			case "+":
				result = result.add(new BigInteger(input.nextLine()));
				break;
			case "-":
				result = result.subtract(new BigInteger(input.nextLine()));
				break;
			case "/":
				result = result.divide(new BigInteger(input.nextLine()));
				break;
			case "*":
				result = result.multiply(new BigInteger(input.nextLine()));
				break;
			}

			if (line.equals("="))
				break;
		}

		System.out.print(result.toString());
	}
}