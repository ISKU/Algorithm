/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2920
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] scale = new int[9];

		for (int index = 1; index < scale.length; index++)
			scale[index] = input.nextInt();

		check(scale);
	}

	private static void check(int[] scale) {
		for (int index = 1; index < scale.length; index++) {
			if (index != scale[index]) {
				for (int jndex = scale.length - 1, count = 1; jndex >= 1; jndex--, count++) {
					if (jndex != scale[count]) {
						System.out.print("mixed");
						return;
					}
				}
				System.out.print("descending");
				return;
			}
		}
		System.out.print("ascending");
		return;
	}
}