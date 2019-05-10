/*
 * Author: Minho Kim (ISKU)
 * Date: May 10, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15820
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S1 = Integer.parseInt(st.nextToken());
		int S2 = Integer.parseInt(st.nextToken());

		boolean sample = true;
		boolean system = true;
		for (int i = 0; i < S1; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());

			if (first != second)
				sample = false;
		}
		for (int i = 0; i < S2; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());

			if (first != second)
				system = false;
		}

		if (sample && system)
			System.out.println("Accepted");
		else if (!sample)
			System.out.println("Wrong Answer");
		else if (sample && !system)
			System.out.println("Why Wrong!!!");
	}
}