/*
 * Author: Minho Kim (ISKU)
 * Date: July 15, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15904
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		char[] line = new Scanner(System.in).nextLine().toCharArray();
		char[] target = new char[] { 'U', 'C', 'P', 'C' };

		int p = 0;
		boolean check = false;
		for (int i = 0; i < line.length; i++) {
			if (line[i] == target[p])
				p++;
			if (p == 4) {
				check = true;
				break;
			}
		}

		System.out.print(check ? "I love UCPC" : "I hate UCPC");
	}
}