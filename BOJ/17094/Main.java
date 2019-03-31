/*
 * Author: Minho Kim (ISKU)
 * Date: March 31, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17094
 */

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int two = 0;
		int e = 0;
		String S = br.readLine();
		for (int i = 0; i < N; i++) {
			if (S.charAt(i) == '2')
				two++;
			else
				e++;
		}

		System.out.println((two == e) ? "yee" : (two > e) ? "2" : "e");
	}
}