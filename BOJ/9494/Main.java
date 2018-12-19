/*
 * Author: Minho Kim (ISKU)
 * Date: December 19, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9494
 */

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			boolean[][] lines = new boolean[N][100];
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				int j = 0;

				for (; j < line.length(); j++)
					if (line.charAt(j) == ' ')
						lines[i][j] = true;
				for (; j < 100; j++)
					lines[i][j] = true;
			}

			int pointer = 0;
			for (int i = 0; i < N; i++)
				for (; pointer < 100; pointer++)
					if (lines[i][pointer])
						break;

			bw.write(String.valueOf(pointer + 1));
			bw.write('\n');
		}

		bw.close();
	}
}