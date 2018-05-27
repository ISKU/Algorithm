/*
 * Author: Minho Kim (ISKU)
 * Date: May 27, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15781
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int helmet = 0;
		while (N-- > 0)
			helmet = Math.max(helmet, sc.nextInt());

		int armor = 0;
		while (M-- > 0)
			armor = Math.max(armor, sc.nextInt());

		System.out.print(helmet + armor);
	}
}