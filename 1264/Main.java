/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.05.03
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1264
 */

import java.util.Scanner;
import java.util.HashSet;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		HashSet<Character> set = new HashSet<Character>() {{
				add('a');
				add('A');
				add('e');
				add('E');
				add('i');
				add('I');
				add('o');
				add('O');
				add('u');
				add('U');
		}};

		while (true) {
			char[] line = input.nextLine().toCharArray();
			if (line[0] == '#')
				break;

			int count = 0;
			for (int i = 0; i < line.length; i++)
				count = (set.contains(line[i])) ? count + 1 : count;

			System.out.println(count);
		}
	}

}