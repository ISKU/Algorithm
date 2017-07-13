/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.06
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2133
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		int size = new Scanner(System.in).nextInt();
		int[] table = new int[size + 1];

		if (size <= 1)
			table[0] = 1;
		else if (size <= 2)
			table[2] = 3;
		else {
			table[0] = 1;
			table[2] = 3;
			for (int i = 4; i <= size; i += 2) {
				table[i] = 3 * table[i - 2];
				for (int j = 4; j <= i; j += 2)
					table[i] += 2 * table[i - j];
			}
		}
		System.out.print(table[size]);
	}
}