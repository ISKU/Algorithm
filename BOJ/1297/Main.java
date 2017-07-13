/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.16
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1297
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int r = input.nextInt();
		int h = input.nextInt();
		int w = input.nextInt();

		double one = r / Math.sqrt((h * h) + (w * w));
		System.out.print((int) Math.floor(h * one) + " " + (int) Math.floor(w * one));
	}
}