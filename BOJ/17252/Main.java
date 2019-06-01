/*
 * Author: Minho Kim (ISKU)
 * Date: June 1, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17252
 */

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N == 0)
			exit();

		while (N > 0) {
			if (N % 3 == 2)
				exit();
			N /= 3;
		}

		System.out.print("YES");
	}

	private static void exit() {
		System.out.print("NO");
		System.exit(0);
	}
}