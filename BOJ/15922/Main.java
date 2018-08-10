/*
 * Author: Minho Kim (ISKU)
 * Date: August 8, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15922
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long answer = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		long px = Long.parseLong(st.nextToken());
		long py = Long.parseLong(st.nextToken());
		while (N-- > 1) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());

			if (px <= x && y <= py)
				continue;
			if (py <= x)
				answer += py - px;
			if (x < py)
				answer += x - px;

			px = x;
			py = y;
		}

		answer += py - px;
		System.out.println(answer);
	}
}