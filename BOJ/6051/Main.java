/*
 * Author: Minho Kim (ISKU)
 * Date: January 29, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/6051
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		ArrayList<LinkedList<Integer>> table = new ArrayList<LinkedList<Integer>>();
		table.add(new LinkedList<Integer>());

		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			if ("a".equals(command)) {
				int value = Integer.parseInt(st.nextToken());
				LinkedList<Integer> list = (LinkedList<Integer>) table.get(n - 1).clone();
				list.add(value);
				table.add(list);
				bw.write(String.valueOf(value));
				bw.newLine();
			}
			else if ("s".equals(command)) {
				LinkedList<Integer> list = (LinkedList<Integer>) table.get(n - 1).clone();
				list.pollLast();
				bw.write(String.valueOf((list.isEmpty()) ? -1 : list.getLast()));
				table.add(list);
				bw.newLine();
			}
			else if ("t".equals(command)) {
				int value = Integer.parseInt(st.nextToken());
				LinkedList<Integer> list = (LinkedList<Integer>) table.get(value - 1).clone();
				table.add(list);
				bw.write(String.valueOf((list.isEmpty()) ? -1 : list.getLast()));
				bw.newLine();
			}
		}

		bw.close();
	}
}