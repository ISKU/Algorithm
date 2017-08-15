/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.08.15
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4158
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			int N = input.nextInt();
			int M = input.nextInt();
			if (N == 0 && M == 0)
				break;

			HashSet<Integer> set = new HashSet<Integer>();
			while (N-- > 0)
				set.add(input.nextInt());

			int count = 0;
			while (M-- > 0)
				if (set.contains(input.nextInt()))
					count++;

			System.out.println(count);
		}
	}
}