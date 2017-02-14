/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.14
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1193
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		int x = new Scanner(System.in).nextInt();
		int g = (int) ((Math.sqrt((8 * x) - 7) - 1) / 2) + 1;
		int m = (g * (g + 1)) / 2;
		System.out.printf("%d/%d\n", (g % 2 == 1 ? m - x + 1 : x - m + g), (g % 2 == 1 ? x - m + g : m - x + 1));
	}
}