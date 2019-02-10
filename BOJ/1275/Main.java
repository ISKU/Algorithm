/*
 * Author: Minho Kim (ISKU)
 * Date: February 9, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1275
 */

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int SQRT = (int) Math.sqrt(N);
		long[] array = new long[N];
		long[] sum = new long[N / SQRT + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Long.parseLong(st.nextToken());
			sum[i / SQRT] += array[i];
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken()) - 1;
			int r = Integer.parseInt(st.nextToken()) - 1;
			int i = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken());
			if (l > r) {
				int temp = r;
				r = l;
				l = temp;
			}

			long answer = 0;
			while (l <= r && l % SQRT != 0)
				answer += array[l++];
			while (l + SQRT < r) {
				answer += sum[l / SQRT];
				l += SQRT;
			}
			while (l <= r)
				answer += array[l++];

			bw.write(String.valueOf(answer));
			bw.write('\n');

			sum[i / SQRT] += v - array[i];
			array[i] = v;
		}

		bw.close();
	}
}