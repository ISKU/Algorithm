/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.12.21
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13752
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();

		while (N-- > 0) {
			int n = input.nextInt();
			while (n-- > 0)
				System.out.print("=");
			System.out.println();
		}
	}
}