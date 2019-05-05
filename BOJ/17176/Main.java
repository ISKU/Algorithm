/*
 * Author: Minho Kim (ISKU)
 * Date: May 4, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17176
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] crypto = new int[53];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			crypto[Integer.parseInt(st.nextToken())]++;

		String line = br.readLine();
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);

			if (c == ' ')
				crypto[0]--;
			else if (c <= 'Z')
				crypto[c - 'A' + 1]--;
			else if (c <= 'z')
				crypto[c - 'a' + 27]--;
		}

		for (int i = 0; i < 53; i++) {
			if (crypto[i] != 0) {
				System.out.println("n");
				System.exit(0);
			}
		}
		System.out.println("y");
	}
}