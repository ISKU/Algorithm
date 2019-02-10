/*
 * Author: Minho Kim (ISKU)
 * Date: February 8, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1321
 */

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		int SQRT = (int) Math.sqrt(N);
		int[] array = new int[N];
		int[] sum = new int[N / SQRT + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			sum[i / SQRT] += array[i];
		}

		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());

			if (cmd == 1) {
				int i = Integer.parseInt(st.nextToken()) - 1;
				int v = Integer.parseInt(st.nextToken());
				array[i] += v;
				sum[i / SQRT] += v;
			}
			if (cmd == 2) {
				int i = Integer.parseInt(st.nextToken());

				int l = 0;
				int count = 0;
				while (l < N && count + sum[l / SQRT] < i) {
					count += sum[l / SQRT];
					l += SQRT;
				}
				while (l < N && count + array[l] < i)
					count += array[l++];

				bw.write(String.valueOf(l + 1));
				bw.write('\n');
			}
		}

		bw.close();
	}
}