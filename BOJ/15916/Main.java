/*
 * Author: Minho Kim (ISKU)
 * Date: July 20, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15916
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] Y = new int[N + 1];
		for (int i = 1; i <= N; i++)
			Y[i] = Integer.parseInt(st.nextToken());
		double K = Double.parseDouble(br.readLine());

		boolean check = false;
		for (int i = 1; i <= N; i++) {
			double x1 = i - 1;
			double y1 = Y[i - 1];
			double x2 = i;
			double y2 = Y[i];

			double m = (y2 - y1) / (x2 - x1);
			double k = -1 * x1 * m + y1;

			if (K == m) {
				if (k == 0)
					check = true;
				continue;
			}

			double intersection = k / (K - m);
			if (i - 1 <= intersection && intersection <= i && intersection != 0)
				check = true;
		}

		System.out.print(check ? "T" : "F");
	}
}