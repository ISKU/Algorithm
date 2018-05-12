/*
 * Author: Minho Kim (ISKU)
 * Date: May 12, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/977/C
 */

import java.util.*;
import java.io.*;

public class C {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> array = new ArrayList<Integer>(N + 1);
		array.add(0);
		for (int i = 1; i <= N; i++)
			array.add(Integer.parseInt(st.nextToken()));

		Collections.sort(array);

		if (K == 0)
			bw.write(String.valueOf(array.get(1) == 1 ? -1 : array.get(1) - 1));
		else if ((K + 1 <= N && array.get(K + 1).equals(array.get(K))))
			bw.write("-1");
		else
			bw.write(String.valueOf(array.get(K)));

		bw.close();
	}
}