/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.12.29
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14595
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();

		int[] club = new int[N];
		for (int i = 0; i < club.length; i++)
			club[i] = i;

		while (M-- > 0) {
			int start = input.nextInt() - 1;
			int end = input.nextInt() - 1;
			int endR = ((end + 1) < N) ? club[end + 1] : 0;

			if (endR != 0 && club[end] == endR) {
				for (int i = end; i < N; i++) {
					if (club[i] == endR)
						club[i] = club[start];
					else
						break;
				}
			}

			for (int i = start; i <= end; i++)
				club[i] = club[start];
		}

		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : club)
			set.add(i);

		System.out.print(set.size());
	}
}