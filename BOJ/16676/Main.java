/*
 * Author: Minho Kim (ISKU)
 * Date: December 10, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16676
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		int N = new Scanner(System.in).nextInt();

		if (0 <= N && N <= 10)
			System.out.print(1);
		else if (11 <= N && N <= 110)
			System.out.print(2);
		else if (111 <= N && N <= 1110)
			System.out.print(3);
		else if (1111 <= N && N <= 11110)
			System.out.print(4);
		else if (11111 <= N && N <= 111110)
			System.out.print(5);
		else if (111111 <= N && N <= 1111110)
			System.out.print(6);
		else if (1111111 <= N && N <= 11111110)
			System.out.print(7);
		else if (11111111 <= N && N <= 111111110)
			System.out.print(8);
		else if (111111111 <= N && N <= 1111111110)
			System.out.print(9);
	}
}