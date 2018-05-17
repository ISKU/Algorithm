/*
 * Author: Minho Kim (ISKU)
 * Date: May 16, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15727
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		int L = new Scanner(System.in).nextInt();
		System.out.print(L / 5 + ((L % 5 == 0) ? 0 : 1));
	}
}