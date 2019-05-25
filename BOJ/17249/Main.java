/*
 * Author: Minho Kim (ISKU)
 * Date: May 25, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17249
 */

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] line = br.readLine().toCharArray();

		int total = 0;
		int left = 0;
		for (int i = 0; i < line.length; i++)
			if (line[i] == '@')
				total++;
		for (int i = 0; line[i] != '0'; i++)
			if (line[i] == '@')
				left++;

		System.out.printf("%d %d", left, total - left);
	}
}