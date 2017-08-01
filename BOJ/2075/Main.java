/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.08.01
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2075
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(parser.nextToken());

		ArrayList<Integer> array = new ArrayList<Integer>(N);
		for (int i = 0; i < N; i++) {
			parser = new StringTokenizer(input.readLine());
			while (parser.hasMoreTokens())
				array.add(Integer.parseInt(parser.nextToken()));
		}

		Collections.sort(array, Collections.reverseOrder());
		System.out.print(array.get(N - 1));
	}
}