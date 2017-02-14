/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.14
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9507
 */

import java.util.Scanner;
import java.math.BigInteger;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		BigInteger[] fibo = new BigInteger[68];
		int testCase = input.nextInt();

		fibo[0] = new BigInteger("1");
		fibo[1] = new BigInteger("1");
		fibo[2] = new BigInteger("2");
		fibo[3] = new BigInteger("4");

		for (int i = 4; i <= 67; i++)
			fibo[i] = fibo[i - 1].add(fibo[i - 2]).add(fibo[i - 3]).add(fibo[i - 4]);

		while (testCase-- > 0)
			System.out.println(fibo[input.nextInt()]);
	}
}