/*
 * Author: Minho Kim (ISKU)
 * Date: May 26, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14425
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<String> set = new HashSet<>();
		while (N-- > 0)
			set.add(br.readLine());

		int count = 0;
		while (M-- > 0)
			if (set.contains(br.readLine()))
				count++;

		System.out.print(count);
	}
}