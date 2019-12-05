/*
 * Author: Minho Kim (ISKU)
 * Date: December 5, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17826
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] score = new int[50];
		for (int i = 0; i < 50; i++)
			score[i] = Integer.parseInt(st.nextToken());

		int target = Integer.parseInt(br.readLine());
		for (int i = 49; i >= 0; i--) {
			if (score[i] == target) {
				System.out.println(getGrade(i + 1));
				break;
			}
		}
	}

	private static String getGrade(int rank) {
		if (rank <= 5)
			return "A+";
		if (rank <= 15)
			return "A0";
		if (rank <= 30)
			return "B+";
		if (rank <= 35)
			return "B0";
		if (rank <= 45)
			return "C+";
		if (rank <= 48)
			return "C0";
		return "F";
	}
}
