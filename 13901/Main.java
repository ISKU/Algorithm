/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.14
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13901
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		boolean[][] graph = new boolean[input.nextInt()][input.nextInt()];

		int hazard = input.nextInt();
		while (hazard-- > 0)
			graph[input.nextInt()][input.nextInt()] = true;

		int y = input.nextInt();
		int x = input.nextInt();

		int[] way = new int[4];
		for (int i = 0; i < 4; i++)
			way[i] = input.nextInt();

		int curWay = 0;
		while (true) {
			graph[y][x] = true;

			if ((y - 1 < 0 || graph[y - 1][x]) && (y + 1 >= graph.length || graph[y + 1][x])
					&& (x - 1 < 0 || graph[y][x - 1]) && (x + 1 >= graph[0].length || graph[y][x + 1])) {
				System.out.println(y + " " + x);
				System.exit(0);
			}

			if (way[curWay % 4] == 1 && y - 1 >= 0 && !graph[y - 1][x]) {
				y = y - 1;
			} else if (way[curWay % 4] == 2 && y + 1 < graph.length && !graph[y + 1][x]) {
				y = y + 1;
			} else if (way[curWay % 4] == 3 && x - 1 >= 0 && !graph[y][x - 1]) {
				x = x - 1;
			} else if (way[curWay % 4] == 4 && x + 1 < graph[0].length && !graph[y][x + 1]) {
				x = x + 1;
			} else {
				curWay += 1;
			}
		}
	}
}