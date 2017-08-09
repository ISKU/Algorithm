/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.08.09
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2851
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		Mario[] mario = new Mario[10];

		int first = input.nextInt();
		mario[0] = new Mario(first, 100 - first);
		for (int i = 1; i < 10; i++) {
			int sum = mario[i - 1].value + input.nextInt();
			mario[i] = new Mario(sum, Math.abs(100 - sum));
		}

		Arrays.sort(mario);
		System.out.print(mario[0].value);
	}

	private static class Mario implements Comparable<Mario> {
		public int value;
		public int diff;

		public Mario(int value, int diff) {
			this.value = value;
			this.diff = diff;
		}

		@Override
		public int compareTo(Mario o) {
			if (this.diff < o.diff)
				return -1;
			else if (this.diff > o.diff)
				return 1;
			else
				return o.value - this.value;
		}
	}
}