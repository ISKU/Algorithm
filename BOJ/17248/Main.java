/*
 * Author: Minho Kim (ISKU)
 * Date: May 25, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17248
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int Z = Integer.parseInt(st.nextToken());

			int v = 0;
			int time = 0;
			while (v < Y - X) {
				time++;
				v += Z * time;
			}

			bw.write(time + "\n");
		}

		bw.close();
	}
}