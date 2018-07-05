/*
 * Author: Minho Kim (ISKU)
 * Date: July 5, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15873
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		String AB = new Scanner(System.in).next();

		if (AB.contains("10"))
			System.out.print(Integer.parseInt(AB.replaceFirst("10", "")) + 10);
		else
			System.out.print((AB.charAt(0) - '0') + (AB.charAt(1) - '0'));
	}
}