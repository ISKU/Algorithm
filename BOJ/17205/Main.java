/*
 * Author: Minho Kim (ISKU)
 * Date: May 17, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17205
 */

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] pwd = br.readLine().toCharArray();

		long time = 0;
		for (int i = 0; i < pwd.length; i++) {
			if (i == N - 1) {
				time += pwd[i] - 'a' + 1;
				break;
			}

			long count = 26;
			for (int j = i + 2; j < N; j++)
				count = count * 26 + 26;

			time += (pwd[i] - 'a') * count + (pwd[i] - 'a' + 1);
		}

		System.out.println(time);
	}
}