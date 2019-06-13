/*
 * Author: Minho Kim (ISKU)
 * Date: June 11, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17262
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int first = Integer.MIN_VALUE;
		int second = Integer.MAX_VALUE;
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			first = Math.max(first, s);
			second = Math.min(second, e);
		}

		System.out.print((first - second) <= 0 ? 0 : first - second);
	}
}