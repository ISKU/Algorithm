/*
 * Author: Minho Kim (ISKU)
 * Date: April 7, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://codejam.withgoogle.com/2018/challenges/00000000000000cb/dashboard/00000000000079cb
 */

import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());

			int[] odd = new int[(N % 2 == 1) ? N / 2 + 1 : N / 2];
			int[] even = new int[N / 2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0, j = 0, k = 1; k <= N; k++) {
				if ((k & 1) == 1)
					odd[i++] = Integer.parseInt(st.nextToken());
				else
					even[j++] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(odd);
			Arrays.sort(even);

			int[] array = new int[N];
			for (int i = 0, j = 0, k = 1; k <= N; k++)
				array[k - 1] = ((k & 1) == 1) ? odd[i++] : even[j++];

			boolean check = false;
			for (int i = 0; i < N - 1; i++) {
				if (array[i] > array[i + 1]) {
					bw.write(String.format("Case #%d: %d\n", t, i));
					check = true;
					break;
				}
			}

			if (!check)
				bw.write(String.format("Case #%d: OK\n", t));
		}

		bw.close();
	}
}