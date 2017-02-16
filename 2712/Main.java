/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.16
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2712
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			float number = input.nextFloat();
			String unit = input.next();

			switch (unit) {
			case "kg":
				System.out.printf("%.4f lb\n", number * 2.2046);
				break;
			case "l":
				System.out.printf("%.4f g\n", number * 0.2642);
				break;
			case "lb":
				System.out.printf("%.4f kg\n", number * 0.4536);
				break;
			case "g":
				System.out.printf("%.4f l\n", number * 3.7854);
				break;
			}

		}
	}
}