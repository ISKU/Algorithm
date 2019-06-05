/*
 * Author: Minho Kim (ISKU)
 * Date: June 5, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17264
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());

		Set<String> set = new HashSet<>();
		while (P-- > 0) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			char result = st.nextToken().charAt(0);

			if (result == 'W')
				set.add(name);
		}

		int score = 0;
		while (N-- > 0) {
			score += (set.contains(br.readLine())) ? W : -L;
			if (score < 0)
				score = 0;

			if (score >= G) {
				System.out.print("I AM NOT IRONMAN!!");
				System.exit(0);
			}
		}

		System.out.print("I AM IRONMAN!!");
	}
}