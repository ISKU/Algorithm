/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.05.03
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4641
 */

import java.util.Scanner;
import java.util.HashSet;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		OUT: while (true) {
			HashSet<Integer> set = new HashSet<Integer>();
			int count = 0;

			while (true) {
				int number = input.nextInt();
				if (number == -1)
					break OUT;

				if (number == 0) {
					for (int i : set)
						count = (set.contains(i * 2)) ? count + 1 : count;

					break;
				}

				set.add(number);
			}

			System.out.println(count);
		}
	}
}