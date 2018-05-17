/*
 * Author: Minho Kim (ISKU)
 * Date: May 15, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15720
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int size = Math.max(B, Math.max(C, D));
		int[][] menu = new int[3][size];
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; st.hasMoreTokens(); j++) {
				menu[i][j] = Integer.parseInt(st.nextToken());
				sum += menu[i][j];
			}
		}

		for (int i = 0; i < 3; i++)
			Arrays.sort(menu[i]);

		int discount = 0;
		for (int j = size - 1; j >= 0; j--) {
			int set = 0;
			boolean check = true;

			for (int i = 0; i < 3; i++) {
				set += menu[i][j];
				if (menu[i][j] == 0)
					check = false;
			}

			discount += check ? set * 0.9 : set;
		}

		System.out.println(sum);
		System.out.println(discount);
	}
}