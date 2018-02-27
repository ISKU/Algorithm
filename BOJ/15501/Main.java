/*
 * Author: Minho Kim (ISKU)
 * Date: February 28, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15501
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[] origin = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			origin[i] = Integer.parseInt(st.nextToken());

		LinkedList<Integer> list = new LinkedList<Integer>();
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens())
			list.add(Integer.parseInt(st.nextToken()));

		while (list.getFirst() != origin[0])
			list.add(list.pollFirst());

		Integer[] temp = list.toArray(new Integer[list.size()]);
		boolean answer = true;
		for (int i = 0; i < N; i++) {
			if (origin[i] != temp[i].intValue()) {
				answer = false;
				break;
			}
		}

		if (!answer) {
			list.add(list.pollFirst());
			temp = list.toArray(new Integer[list.size()]);
			answer = true;
			for (int i = 0, j = N - 1; i < N; i++, j--)
				if (origin[i] != temp[j].intValue())
					answer = false;
		}

		System.out.print(answer ? "good puzzle" : "bad puzzle");
	}
}