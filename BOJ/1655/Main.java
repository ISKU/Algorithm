/*
 * Author: Minho Kim (ISKU)
 * Date: April 19, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1655
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> min = new PriorityQueue<>();
		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
		max.add(Integer.parseInt(br.readLine()));
		bw.write(max.peek() + "\n");

		while (N-- > 1) {
			int n = Integer.parseInt(br.readLine());

			if (n < max.peek())
				max.add(n);
			else
				min.add(n);

			if (max.size() < min.size())
				max.add(min.poll());
			if (max.size() > min.size() + 1)
				min.add(max.poll());

			bw.write(max.peek() + "\n");
		}

		bw.close();
	}
}