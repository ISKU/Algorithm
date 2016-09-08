/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.08
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1309
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		int[] table = new int[new Scanner(System.in).nextInt() + 1];

		table[0] = 1;
		table[1] = 3;
		for (int i = 2; i < table.length; i++)
			table[i] = (table[i - 2] + table[i - 1] * 2) % 9901;

		System.out.println(table[table.length - 1] % 9901);
	}
}