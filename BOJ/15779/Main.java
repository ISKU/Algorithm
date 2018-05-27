/*
 * Author: Minho Kim (ISKU)
 * Date: May 26, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15779
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] array = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			array[i] = Integer.parseInt(st.nextToken());

		int answer = 2;
		for (int i = 0; i < N - 2; i++) {
			int count = 2;
			boolean reverse = (array[i] <= array[i + 1]);

			for (int j = i + 2; j < N; j++) {
				if (reverse && array[j - 1] <= array[j])
					break;
				if (!reverse && array[j - 1] >= array[j])
					break;

				reverse = !reverse;
				count++;
				answer = Math.max(answer, count);
			}
		}

		System.out.print(answer);
	}
}