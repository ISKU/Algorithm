/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.12.26
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15098
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		HashSet<String> set = new HashSet<String>();

		while (input.hasNext()) {
			String word = input.next();
			if (set.contains(word)) {
				System.out.print("no");
				System.exit(0);
			}
			set.add(word);
		}

		System.out.print("yes");
	}
}