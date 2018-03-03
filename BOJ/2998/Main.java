/*
 * Author: Minho Kim (ISKU)
 * Date: March 3, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2998
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		String bin = new Scanner(System.in).next();

		StringBuilder answer = new StringBuilder();
		for (int i = bin.length(); i > 0; i -= 3)
			answer.insert(0, Integer.toOctalString(Integer.parseInt(bin.substring((i - 3) <= 0 ? 0 : i - 3, i), 2)));

		System.out.print(answer);
	}
}