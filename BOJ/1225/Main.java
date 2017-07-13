/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.03
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1225
 */

import java.util.Scanner;
import java.math.BigInteger;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		String[] first = input.next().split("");
		String[] second = input.next().split("");
		BigInteger sum = BigInteger.ZERO;


		for (int i = 0; i < first.length; i++)
			for (int j = 0; j < second.length; j++)
				sum = sum.add(BigInteger.valueOf(Integer.parseInt(first[i]) * Integer.parseInt(second[j])));

		System.out.print(sum);
	}
}