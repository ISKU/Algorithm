/*
 * Author: Minho Kim (ISKU)
 * Date: May 16, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15725
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		String line = new Scanner(System.in).nextLine();

		int end = 0;
		boolean check = false;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == 'x') {
				end = i;
				check = true;
				break;
			}
		}

		if (end == 1 && line.charAt(0) == '-' && check)
			System.out.print(-1);
		else if (end == 0 && check)
			System.out.print(1);
		else if (line.charAt(end) == 'x')
			System.out.print(Integer.parseInt(line.substring(0, end)));
		else
			System.out.print(0);
	}
}