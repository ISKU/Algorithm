/*
 * Author: Minho Kim (ISKU)
 * Date: March 19, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10774
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int J = Integer.parseInt(br.readLine());
		int A = Integer.parseInt(br.readLine());

		int[] jerseys = new int[J + 1];
		for (int i = 1; i <= J; i++) {
			char size = br.readLine().charAt(0);
			jerseys[i] = (size == 'M') ? 1 : (size == 'L') ? 2 : 0;
		}

		int count = 0;
		while (A-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char size = st.nextToken().charAt(0);
			int number = Integer.parseInt(st.nextToken());

			if (jerseys[number] >= ((size == 'M') ? 1 : (size == 'L') ? 2 : 0)) {
				jerseys[number] = -1;
				count++;
			}
		}

		System.out.print(count);
	}
}