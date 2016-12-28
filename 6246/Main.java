/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.12.28
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/6246
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String... args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		boolean[] slot = new boolean[Integer.parseInt(parser.nextToken()) + 1];
		int count = 0;

		for (int i = Integer.parseInt(parser.nextToken()); i > 0; i--) {
			parser = new StringTokenizer(input.readLine());

			for (int start = Integer.parseInt(parser.nextToken()), period = Integer.parseInt(parser.nextToken()), j = 0;; j++) {
				int index = start + (period * j);
				if (index > slot.length - 1)
					break;
				slot[index] = true;
			}
		}

		for (int i = 1; i < slot.length; i++)
			if (!slot[i])
				count++;

		System.out.println(count);
	}
}