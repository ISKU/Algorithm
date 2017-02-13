/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.13
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2530
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int time = input.nextInt() * 3600 + input.nextInt() * 60 + input.nextInt() + input.nextInt();
		System.out.print((time / 3600) % 24);
		time %= 3600;
		System.out.print(" " + time / 60);
		time %= 60;
		System.out.print(" " + time);
	}
}