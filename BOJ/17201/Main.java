/*
 * Author: Minho Kim (ISKU)
 * Date: May 14, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17201
 */

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		char[] line = br.readLine().toCharArray();
		for (int i = 1; i < N * 2; i++) {
			if (line[i] == line[i - 1]) {
				System.out.print("No");
				return;
			}
		}

		System.out.print("Yes");
	}
}