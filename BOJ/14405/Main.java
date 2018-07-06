/*
 * Author: Minho Kim (ISKU)
 * Date: July 6, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14405
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		System.out.print((new Scanner(System.in).next().replaceAll("pi|ka|chu", "").length() == 0) ? "YES" : "NO");
	}
}