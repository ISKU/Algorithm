/*
 * Author: Minho Kim (ISKU)
 * Date: November 11, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16396
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[] line = new boolean[10001];
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			for (int i = start; i < end; i++)
				line[i] = true;
		}

		int count = 0;
		for (int i = 1; i <= 10000; i++)
			if (line[i])
				count++;
		System.out.print(count);
	}
}