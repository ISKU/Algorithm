/*
 * Author: Minho Kim (ISKU)
 * Date: October 30, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16212
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] array = new int[N];
		for (int i = 0; i < N; i++)
			array[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(array);

		for (int i = 0; i < N; i++) {
			bw.write(String.valueOf(array[i]));
			bw.write(' ');
		}
		bw.close();
	}
}