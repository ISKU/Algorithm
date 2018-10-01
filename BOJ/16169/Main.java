/*
 * Author: Minho Kim (ISKU)
 * Date: September 29, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16169
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Set<Integer> levels = new TreeSet<>();
		Computer[] computers = new Computer[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int level = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			computers[i] = new Computer(i + 1, level, speed);
			levels.add(level);
		}

		ArrayList<Computer>[] list = new ArrayList[levels.size()];
		for (int i = 0; i < list.length; i++)
			list[i] = new ArrayList<Computer>();
		int iter = 0;
		for (int level : levels) {
			for (int i = 0; i < N; i++)
				if (computers[i].level == level)
					list[iter].add(computers[i]);
			iter++;
		}

		for (int k = 1; k < list.length; k++)
			for (Computer i : list[k - 1])
				for (Computer j : list[k])
					j.sum = Math.max(j.sum, i.sum + i.speed + (i.index - j.index) * (i.index - j.index));

		int sum = 0;
		for (Computer computer : list[list.length - 1])
			sum = Math.max(sum, computer.sum + computer.speed);
		System.out.print(sum);
	}

	private static class Computer {
		public int index, level, speed;
		public int sum;

		public Computer(int index, int level, int speed) {
			this.index = index;
			this.level = level;
			this.speed = speed;
			this.sum = 0;
		}
	}
}