/*
 * Author: Minho Kim (ISKU)
 * Date: May 12, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17072
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int R = Integer.parseInt(st.nextToken());
				int G = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				map[i][j] = 2126 * R + 7152 * G + 722 * B;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] < 510000)
					bw.write('#');
				else if (map[i][j] < 1020000)
					bw.write('o');
				else if (map[i][j] < 1530000)
					bw.write('+');
				else if (map[i][j] < 2040000)
					bw.write('-');
				else
					bw.write('.');
			}
			bw.write('\n');
		}

		bw.close();
	}
}