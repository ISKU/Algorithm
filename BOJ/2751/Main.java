/*
 * Author: Minho Kim (ISKU)
 * Date: April 20, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2751
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		Integer[] array = new Integer[N];
		for (int i = 0; i < N; i++)
			array[i] = Integer.parseInt(br.readLine());

		Arrays.sort(array);

		for (int i = 0; i < N; i++)
			bw.write(array[i] + "\n");
		bw.close();
	}
}
