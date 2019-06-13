/*
 * Author: Minho Kim (ISKU)
 * Date: June 13, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17224
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		List<Integer> array = new ArrayList<>();
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int easy = Integer.parseInt(st.nextToken());
			int hard = Integer.parseInt(st.nextToken());

			if (hard <= L)
				array.add(140);
			else if (easy <= L)
				array.add(100);
		}
		Collections.sort(array, Collections.reverseOrder());

		int sum = 0;
		for (int i = 0; i < K && i < array.size(); i++)
			sum += array.get(i);

		System.out.print(sum);
	}
}