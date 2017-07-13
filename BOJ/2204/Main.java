/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.24
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2204
 */

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			int count = input.nextInt();
			if (count == 0)
				break;

			String[] words = new String[count];
			for (int i = 0; i < count; i++)
				words[i] = input.next();

			Arrays.sort(words, new Comparator<String>() {
				@Override
				public int compare(String first, String second) {
					return first.toLowerCase().compareTo(second.toLowerCase());
				}
			});

			System.out.println(words[0]);
		}
	}
}