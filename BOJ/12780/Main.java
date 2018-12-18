/*
 * Author: Minho Kim (ISKU)
 * Date: December 18, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/12780
 */

import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String H = br.readLine();
		String N = br.readLine();

		int count = 0;
		int i = 0;
		while (true) {
			i = H.indexOf(N, i);
			if (i == -1)
				break;

			i += N.length();
			count++;
		}

		System.out.print(count);
	}
}
