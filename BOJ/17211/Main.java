/*
 * Author: Minho Kim (ISKU)
 * Date: May 20, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17211
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int status = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		double gg = Double.parseDouble(st.nextToken());
		double gb = Double.parseDouble(st.nextToken());
		double bg = Double.parseDouble(st.nextToken());
		double bb = Double.parseDouble(st.nextToken());

		double[][] table = new double[N + 1][2];
		table[1][0] = (status == 0) ? gg : bg;
		table[1][1] = (status == 0) ? gb : bb;
		for (int i = 2; i <= N; i++) {
			table[i][0] = (table[i - 1][0] * gg) + (table[i - 1][1] * bg);
			table[i][1] = (table[i - 1][0] * gb) + (table[i - 1][1] * bb);
		}

		System.out.printf("%.0f\n%.0f\n", table[N][0] * 1000, table[N][1] * 1000);
	}
}