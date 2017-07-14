/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.04.16
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/801/B
 */

import java.util.*;
import java.io.*;
import java.math.*;

public class B {
	public static void main(String... args) throws IOException {
		Scanner input = new Scanner(System.in);
		char[] first = input.nextLine().toCharArray();
		char[] ans = input.nextLine().toCharArray();
		char[] second = new char[first.length];

		if (first.length != ans.length) {
			System.out.print(-1);
			System.exit(0);
		}

		for (int i = 0; i < first.length; i++) {
			if (first[i] == ans[i]) {
				if (first[i] == 'z')
					second[i] = 'z';
				else
					second[i] = (char) (first[i] + 1);
			} else if (first[i] > ans[i]) {
				if (first[i] == 'a') {
					System.out.print(-1);
					System.exit(0);
				}
				second[i] = ans[i];
			} else {
				System.out.print(-1);
				System.exit(0);
			}
		}

		for (int i = 0; i < second.length; i++)
			System.out.print(second[i]);
	}
}