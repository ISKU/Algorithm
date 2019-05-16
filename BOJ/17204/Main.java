/*
 * Author: Minho Kim (ISKU)
 * Date: May 14, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17204
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] array = new int[N];
		for (int i = 0; i < N; i++)
			array[i] = Integer.parseInt(br.readLine());

		boolean[] visited = new boolean[N];
		int count = 1;
		for (int i = 0; array[i] != K; i = array[i]) {
			if (visited[i]) {
				count = -1;
				break;
			}

			visited[i] = true;
			count++;
		}

		System.out.print(count);
	}
}