/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.11.16
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13484
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int megabyte = input.nextInt();
		int testCase = input.nextInt();

		megabyte = megabyte * (testCase + 1);
		while (testCase-- > 0)
			megabyte -= input.nextInt();

		System.out.print(megabyte);
	}
}