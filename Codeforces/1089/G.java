/*
 * Author: Minho Kim (ISKU)
 * Date: December 2, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://codeforces.com/problemset/problem/1089/G
 */

import java.util.*;
import java.io.*;

public class G {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			long K = Long.parseLong(br.readLine());
			boolean[] days = new boolean[7];

			long classes = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 7; i++) {
				days[i] = (Integer.parseInt(st.nextToken()) == 1) ? true : false;
				if (days[i])
					classes++;
			}

			long answer = Integer.MAX_VALUE;
			for (int i = 0, c = -1; i < 7; i++) {
				if (!days[i])
					continue;

				c++;
				long k = K + c;
				long week = ((k % classes == 0) ? k / classes - 1 : k / classes);
				for (int j = 1, d = 0; j <= 7; j++) {
					if (!days[j - 1])
						continue;

					d++;
					if (week * classes + d == k) {
						answer = Math.min(answer, week * 7 + j - i);
						break;
					}
				}
			}

			bw.write(String.valueOf(answer));
			bw.write('\n');
		}

		bw.close();
	}
}