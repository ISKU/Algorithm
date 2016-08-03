/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.03
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2338
 */

import java.util.Scanner;
import java.math.BigInteger;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		BigInteger numberA = new BigInteger(input.next());
		BigInteger numberB = new BigInteger(input.next());
		System.out.printf("%s\n%s\n%s\n", numberA.add(numberB), numberA.subtract(numberB), numberA.multiply(numberB));
	}
}