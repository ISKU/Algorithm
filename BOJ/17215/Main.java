/*
 * Author: Minho Kim (ISKU)
 * Date: May 22, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17215
 */

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] info = br.readLine().toCharArray();

		int[] score = new int[info.length];
		int[] chance = new int[info.length];
		int total = 0;
		for (int i = 0, frame = 1; i < info.length; i++, frame++) {
			if (info[i] == 'S') {
				score[i] = 10;
				total += score[i] + (chance[i] * score[i]);

				if (frame < 10) {
					chance[i + 1]++;
					chance[i + 2]++;
				}
			} else {
				if (info[i] != '-') {
					score[i] = (info[i] - '0');
					total += score[i] + (chance[i] * score[i]);
				}

				if (i + 1 < info.length) {
					if (info[i + 1] == 'P') {
						score[i + 1] = 10 - score[i];
						if (i + 2 < info.length && frame < 10)
							chance[i + 2]++;
					} else {
						if (info[i + 1] != '-')
							score[i + 1] = (info[i + 1] - '0');
					}
					total += score[i + 1] + (chance[i + 1] * score[i + 1]);
				}
				i++;
			}
		}

		System.out.print(total);
	}
}