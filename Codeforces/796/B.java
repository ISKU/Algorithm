/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.04.10
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/796/B
 */

import java.util.*;
import java.io.*;
import java.math.*;

public class B {
	public static void main(String... args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		int n = Integer.parseInt(parser.nextToken());
		int m = Integer.parseInt(parser.nextToken());
		int k = Integer.parseInt(parser.nextToken());

		HashSet<Integer> hole = new HashSet<Integer>();
		parser = new StringTokenizer(input.readLine());
		for (int i = 0; i < m; i++)
			hole.add(Integer.parseInt(parser.nextToken()));

		int cur = 1;
		ArrayList<Integer> check = new ArrayList<Integer>();

		if (hole.contains(1))
			check.add(1);

		for (int i = 0; i < k; i++) {
			parser = new StringTokenizer(input.readLine());
			int first = Integer.parseInt(parser.nextToken());
			int second = Integer.parseInt(parser.nextToken());

			if (!check.isEmpty())
				continue;

			if (first == cur) {
				cur = second;
				if (hole.contains(second))
					check.add(second);
			} else if (second == cur) {
				cur = first;
				if (hole.contains(first))
					check.add(first);
			}
		}

		System.out.print(check.isEmpty() ? cur + "" : check.get(0) + "");
	}
}