/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.14
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2884
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int hour = input.nextInt();
		int minute = input.nextInt() - 45;
		if (minute < 0) {
			hour = (hour - 1) < 0 ? 23 : hour - 1;
			minute = 60 + minute;
		}
		System.out.printf("%d %d", hour, minute);
	}
}