/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.28
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2783
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		double x = input.nextDouble();
		double y = input.nextDouble();
		int n = input.nextInt();

		double output = 1000 / y * x;
		while (n-- > 0) {
			x = input.nextDouble();
			y = input.nextDouble();
			output = Math.min(output, 1000 / y * x);
		}
		
		System.out.printf("%.2f", output);
	}
}