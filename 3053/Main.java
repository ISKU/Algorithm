/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.28
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/3053
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		double r = new Scanner(System.in).nextDouble();
		System.out.printf("%.6f\n%.6f", r * r * Math.PI, r * r / 2 * 4);
	}
}