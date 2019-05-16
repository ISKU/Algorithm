/*
 * Author: Minho Kim (ISKU)
 * Date: May 14, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17206
 */

import java.io.*;
import java.util.*;

public class Main {

	public static final int MAX = 80001;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		boolean[] table = new boolean[MAX];
		for (int i = 3; i < MAX; i += 3)
			table[i] = true;
		for (int i = 7; i < MAX; i += 7)
			table[i] = true;

		int[] psum = new int[MAX];
		for (int i = 3; i < MAX; i++)
			psum[i] = psum[i - 1] + ((table[i]) ? i : 0);

		StringTokenizer st = new StringTokenizer(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(st.nextToken());
			bw.write(psum[N] + "\n");
		}

		bw.close();
	}
}