/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.03.27
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/792/A
 */

import java.util.*;
import java.io.*;
import java.math.*;

public class A {
	public static void main(String... args) throws IOException {
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		PriorityQueue<Integer> points = new PriorityQueue<Integer>(size);
		TreeMap<Integer, Integer> table = new TreeMap<Integer, Integer>();

		for (int i = 0; i < size; i++)
			points.add(input.nextInt());

		int save = points.poll();
		while (!points.isEmpty()) {
			int cur = points.poll();
			int dist = Math.abs(cur - save);

			table.put(dist, table.containsKey(dist) ? table.get(dist) + 1 : 1);
			save = cur;
		}

		Iterator<Integer> iteratorKey = table.keySet().iterator();
		int mindist = iteratorKey.next();
		System.out.printf("%d %d", mindist, table.get(mindist));
	}
}