/*
 * Author: Minho Kim (ISKU)
 * Date: August 8, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2721
 */

import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int sum = 0;
			for (int k = 1; k <= n; k++)
				sum += k * (k + 1) * (k + 2) / 2;

			bw.write(sum + "\n");
		}

		bw.close();
	}
}