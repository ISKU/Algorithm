/*
 * Author: Minho Kim (ISKU)
 * Date: July 4, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/12871
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String t = sc.next();

		String first = "";
		String second = "";
		for (int i = 0; i < s.length(); i++)
			second += t;
		for (int i = 0; i < t.length(); i++)
			first += s;

		System.out.print(first.equals(second) ? 1 : 0);
	}
}