/*
 * Author: Minho Kim (ISKU)
 * Date: June 9, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15786
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String S = br.readLine();

		while (M-- > 0) {
			String pass = br.readLine();
			boolean check = false;
			int j = 0;

			for (int i = 0; i < pass.length(); i++) {
				if (S.charAt(j) != pass.charAt(i))
					continue;

				if (++j == N) {
					check = true;
					break;
				}
			}

			bw.write(check ? "true\n" : "false\n");
		}

		bw.close();
	}
}