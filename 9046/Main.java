/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.23
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9046
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = Integer.parseInt(input.nextLine());

		while (testCase-- > 0) {
			char[] line = input.nextLine().toCharArray();
			int[] freq = new int[26];

			for (int i = 0; i < line.length; i++) {
				if (line[i] == ' ')
					continue;
				freq[(int) line[i] % 97]++;
			}

			int max = 0, maxFreq = 0;
			for (int i = 0; i < 26; i++) {
				if (max < freq[i]) {
					max = freq[i];
					maxFreq = i;
				}
			}

			int check = 0;
			for (int i = 0; i < 26; i++)
				if (max == freq[i])
					check++;

			System.out.println(check >= 2 ? "?" : (char) (maxFreq + 97));
		}
	}
}