/*
 * Author: Minho Kim (ISKU)
 * Date: May 6, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/977/A
 */

import java.util.*;
import java.io.*;

public class A {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		while (K-- > 0)
			N = (N % 10 == 0) ? N / 10 : N - 1;

		bw.write(String.valueOf(N));
		bw.close();
	}
}