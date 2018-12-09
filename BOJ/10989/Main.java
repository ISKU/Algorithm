
/*
 * Author: Minho Kim (ISKU)
 * Date: December 8, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10989
 */

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		int[] array = new int[N];
		for (int i = 0; i < N; i++)
			array[i] = Integer.parseInt(br.readLine());

		Arrays.sort(array);
		for (int i = 0; i < N; i++) {
			bw.write(String.valueOf(array[i]));
			bw.write('\n');
		}
		bw.close();
	}
}
