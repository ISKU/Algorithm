/*
 * Author: Minho Kim (ISKU)
 * Date: January 19, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14891
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);

		Gear[] gear = new Gear[4];
		for (int i = 0; i < 4; i++)
			gear[i] = new Gear(sc.next().split(""));

		int K = sc.nextInt();
		while (K-- > 0) {
			int index = sc.nextInt() - 1;
			boolean dir = (sc.nextInt() == 1) ? true : false;

			boolean[] state = new boolean[3];
			for (int i = 0; i < 3; i++)
				state[i] = (gear[i].info[2] == gear[i + 1].info[6]) ? true : false;

			boolean temp = dir;
			for (int i = index; i >= 1; i--) {
				if (state[i - 1])
					break;
				else {
					temp = !temp;
					gear[i - 1].rotate(temp);
				}
			}

			temp = dir;
			for (int i = index; i < 3; i++) {
				if (state[i])
					break;
				else {
					temp = !temp;
					gear[i + 1].rotate(temp);
				}
			}

			gear[index].rotate(dir);
		}

		int sum = 0, s = 1;
		for (int i = 0; i < 4; i++) {
			sum += (gear[i].info[0] == 1) ? s : 0;
			s *= 2;
		}
		System.out.print(sum);
	}

	private static class Gear {
		public int[] info = new int[8];

		public Gear(String[] info) {
			for (int i = 0; i < info.length; i++)
				this.info[i] = Integer.parseInt(info[i]);
		}

		public void rotate(boolean dir) {
			if (dir) {
				int temp = info[7];
				for (int i = 7; i >= 1; i--)
					info[i] = info[i - 1];
				info[0] = temp;
			} else {
				int temp = info[0];
				for (int i = 0; i < 7; i++)
					info[i] = info[i + 1];
				info[7] = temp;
			}
		}
	}
}