/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.01
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5361
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		double[] cost = new double[] { 350.34, 230.90, 190.55, 125.30, 180.90 };
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			double sum = 0;
			for (int i = 0; i < 5; i++)
				sum += input.nextDouble() * cost[i];
			System.out.printf("$%.2f\n", sum);
		}
	}
}