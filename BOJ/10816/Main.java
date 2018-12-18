/*
 * Author: Minho Kim (ISKU)
 * Date: December 18, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10816
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Map<Integer, Integer> table = new HashMap();

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (N-- > 0) {
			int n = Integer.parseInt(st.nextToken());
			table.put(n, table.containsKey(n) ? table.get(n) + 1 : 1);
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while (M-- > 0) {
			int n = Integer.parseInt(st.nextToken());
			bw.write(String.valueOf(table.containsKey(n) ? table.get(n) : Integer.valueOf(0)));
			bw.write(' ');
		}

		bw.close();
	}
}
