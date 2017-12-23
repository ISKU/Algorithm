/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.12.23
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15232
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int R = input.nextInt();
		int C = input.nextInt();

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++)
				System.out.print("*");
			System.out.println();
		}
	}
}