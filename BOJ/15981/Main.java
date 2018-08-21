/*
 * Author: Minho Kim (ISKU)
 * Date: August 21, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15981
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = new Scanner(System.in).nextInt();

		int K = 0;
		for (int d = 1; d < N; d *= 2)
			K++;

		ArrayList<Integer>[] candidate = new ArrayList[K];
		for (int i = 0; i < K; i++)
			candidate[i] = new ArrayList<Integer>();

		for (int i = 1; i <= N; i++) {
			int k = i;
			for (int j = 0; j < K; j++, k >>= 1)
				if ((k & 1) == 1)
					candidate[j].add(i);
		}

		bw.write(K + "\n");
		for (int i = 0; i < K; i++) {
			bw.write(String.valueOf(candidate[i].size()));
			for (int j = 0; j < candidate[i].size(); j++)
				bw.write(" " + candidate[i].get(j));
			bw.newLine();
		}
		bw.close();
	}
}