/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.08.06
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2563
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();

		boolean[][] paper = new boolean[101][101];
		while (N-- > 0) {
			int Y = input.nextInt();
			int X = input.nextInt();

			for (int y = Y; y < Y + 10; y++)
				for (int x = X; x < X + 10; x++)
					paper[y][x] = true;
		}

		int answer = 0;
		for (int y = 1; y < 101; y++)
			for (int x = 1; x < 101; x++)
				if (paper[y][x])
					answer++;

		System.out.print(answer);
	}
}