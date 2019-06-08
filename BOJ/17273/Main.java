/*
 * Author: Minho Kim (ISKU)
 * Date: June 8, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17273
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		boolean fb = true;
		int card = A;
		while (M-- > 0) {
			int K = Integer.parseInt(br.readLine());
			if (card > K)
				continue;

			card = (fb) ? B : A;
			fb = !fb;
		}

		System.out.print(card);
	}
}