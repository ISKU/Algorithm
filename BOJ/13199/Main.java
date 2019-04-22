/*
 * Author: Minho Kim (ISKU)
 * Date: April 22, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13199
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int F = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			int A = M / P;
			int B = M / P;
			int count = M / P;
			int countA = count * C;
			int countB = count * C;

			A += countA / F;
			if (countB - F >= 0)
				B += (countB - F) / (F - C) + 1;

			bw.write((B - A) + "\n");
		}

		bw.close();
	}
}
