/*
 * Author: Minho Kim (ISKU)
 * Date: April 27, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1269
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		Set<Integer> set = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++)
			set.add(Integer.parseInt(st.nextToken()));

		int intersection = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < B; i++)
			if (set.contains(Integer.parseInt(st.nextToken())))
				intersection++;

		System.out.print(A + B - (2 * intersection));
	}
}