/*
 * Author: Minho Kim (ISKU)
 * Date: May 14, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17203
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		int[] array = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			array[i] = Integer.parseInt(st.nextToken());

		int[] delta = new int[N + 1];
		for (int i = 2; i <= N; i++)
			delta[i] = delta[i - 1] + Math.abs(array[i] - array[i - 1]);

		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			int sum = delta[r] - delta[l];
			bw.write(sum + "\n");
		}

		bw.close();
	}
}