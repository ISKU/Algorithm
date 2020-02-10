/*
 * Author: Minho Kim (ISKU)
 * Date: February 10, 2020
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5430
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			char[] commands = br.readLine().toCharArray();
			int N = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
			int[] array = new int[N];
			for (int i = 0; i < N; i++)
				array[i] = Integer.parseInt(st.nextToken());

			boolean reverse = false;
			boolean error = false;
			int front = 0;
			int rear = N - 1;
			for (char c : commands) {
				if (c == 'R')
					reverse = !reverse;
				if (c == 'D') {
					if (reverse)
						rear--;
					else
						front++;

					if (rear - front < -1) {
						error = true;
						break;
					}
				}
			}

			if (error) {
				bw.write("error\n");
			} else {
				bw.write('[');
				if (reverse) {
					if (front <= rear)
						bw.write(String.valueOf(array[rear]));
					for (int i = rear - 1; i >= front; i--)
						bw.write("," + array[i]);
				} else {
					if (front <= rear)
						bw.write(String.valueOf(array[front]));
					for (int i = front + 1; i <= rear; i++)
						bw.write("," + array[i]);
				}
				bw.write("]\n");
			}
		}

		bw.close();
	}
}