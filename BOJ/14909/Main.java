/*
 * Author: Minho Kim (ISKU)
 * Date: March 23, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14909
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		StringTokenizer st = new StringTokenizer(new Scanner(System.in).nextLine());

		int count = 0;
		while (st.hasMoreTokens())
			if (Integer.parseInt(st.nextToken()) > 0)
				count++;

		System.out.print(count);
	}
}