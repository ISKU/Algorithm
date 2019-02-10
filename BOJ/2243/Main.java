/*
 * Author: Minho Kim (ISKU)
 * Date: February 9, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2243
 */

import java.util.*;
import java.io.*;

public class Main {

	public static final int MAX = 1000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int S = (int) Math.sqrt(MAX);
		int[] array = new int[MAX];
		int[] sum = new int[MAX / S + 1];

		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());

			if (cmd == 1) {
				int v = Integer.parseInt(st.nextToken());

				int count = 0;
				int i = 0;
				while (i < MAX && count + sum[i / S] < v) {
					count += sum[i / S];
					i += S;
				}
				while (i < MAX && count + array[i] < v)
					count += array[i++];

				array[i]--;
				sum[i / S]--;

				bw.write(String.valueOf(i + 1));
				bw.write('\n');
			}
			if (cmd == 2) {
				int i = Integer.parseInt(st.nextToken()) - 1;
				int v = Integer.parseInt(st.nextToken());
				array[i] += v;
				sum[i / S] += v;
			}
		}

		bw.close();
	}
}