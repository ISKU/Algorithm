/*
 * Author: Minho Kim (ISKU)
 * Date: August 25, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15989
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		while (T-- > 0)
			System.out.println(get(sc.nextInt()));
	}

	private static int get(int N) {
		int count = 1;

		for (int i = 2; i <= N; i += 2)
			count++;
		for (int i = 3; i <= N; i += 3)
			count++;
		for (int i = 2; i <= N; i += 2)
			for (int j = i + 3; j <= N; j += 3)
				count++;

		return count;
	}
}