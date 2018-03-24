/*
 * Author: Minho Kim (ISKU)
 * Date: March 23, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14914
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int apple = sc.nextInt();
		int banana = sc.nextInt();

		for (int i = 1; i <= Math.min(apple, banana); i++)
			if (apple % i == 0 && banana % i == 0)
				System.out.printf("%d %d %d\n", i, apple / i, banana / i);
	}
}