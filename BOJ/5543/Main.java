/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.10
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5543
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int[] bug = new int[] { input.nextInt(), input.nextInt(), input.nextInt() };
		int[] water = new int[] { input.nextInt(), input.nextInt() };
		int set = Integer.MAX_VALUE;

		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 2; j++)
				set = Math.min(set, bug[i] + water[j]);

		System.out.println(set - 50);
	}
}