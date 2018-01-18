/*
 * Author: Minho Kim (ISKU)
 * Date: January 18, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1408
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int[] time = new int[3];

		for (int i = 0; i < 2; i++) {
			String[] line = sc.next().split(":");
			int s = 3600;
			for (int j = 0; j < 3; j++) {
				time[i] += Integer.parseInt(line[j]) * s;
				s /= 60;
			}
		}

		int temp = time[1] - time[0];
		int answer = (temp < 0) ? 86400 + temp : temp;
		int s = 3600;
		for (int i = 0; i < 3; i++) {
			time[i] = answer / s;
			answer %= s;
			s /= 60;
		}

		System.out.printf("%02d:%02d:%02d", time[0], time[1], time[2]);
	}
}