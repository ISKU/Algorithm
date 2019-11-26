/*
 * Author: Minho Kim (ISKU)
 * Date: November 25, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/18127
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		long answer = 1;
		long d = 1;
		for (int i = 1; i <= b; i++) {
			d += a - 2;
			answer += d;
		}

		System.out.println(answer);
	}
}
