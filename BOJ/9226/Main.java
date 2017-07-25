/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.26
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9226
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			char[] word = input.nextLine().toCharArray();
			if (word[0] == '#')
				break;

			StringBuilder back = new StringBuilder();
			int i = 0;
			while (i < word.length) {
				if (word[i] == 'a' || word[i] == 'e' || word[i] == 'i' || word[i] == 'o' || word[i] == 'u')
					break;
				back.append(word[i++]);
			}

			while (i < word.length)
				System.out.print(word[i++]);
			System.out.println(back + "ay");
		}
	}
}