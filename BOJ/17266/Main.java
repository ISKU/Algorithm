/*
 * Author: Minho Kim (ISKU)
 * Date: June 6, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17266
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[] lamps = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			lamps[i] = Integer.parseInt(st.nextToken());

		int answer = Math.max(lamps[0], N - lamps[M - 1]);
		for (int i = 1; i < M; i++)
			answer = Math.max(answer, (lamps[i] - lamps[i - 1] + 1) / 2);

		System.out.print(answer);
	}
}