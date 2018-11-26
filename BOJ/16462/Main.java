/*
 * Author: Minho Kim (ISKU)
 * Date: November 25, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16462
 */

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		double sum = 0;
		for (int i = 0; i < N; i++) {
			int grade = Integer.parseInt(br.readLine().replaceAll("0|6|9", "9"));
			if (grade >= 100)
				grade = 100;

			sum += grade;
		}

		System.out.printf("%.0f", sum / N);
	}
}