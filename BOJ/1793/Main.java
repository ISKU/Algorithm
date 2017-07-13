/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.07
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1793
 */

import java.util.Scanner;
import java.math.BigInteger;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		BigInteger[] numberOfRectangle = new BigInteger[250];

		numberOfRectangle[0] = new BigInteger("1");
		numberOfRectangle[1] = new BigInteger("3");
		numberOfRectangle[2] = new BigInteger("5");
		for (int index = 3; index < 250; index++)
			numberOfRectangle[index] = 
				new BigInteger(numberOfRectangle[index - 1].add(numberOfRectangle[index - 2].multiply(new BigInteger("2"))).toString());

		while (input.hasNextInt()) {
			int number = input.nextInt();
			System.out.println((number == 0) ? 1 : numberOfRectangle[number - 1].toString());
		}
	}
}