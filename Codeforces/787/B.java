/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.03.23
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/787/B
 */

import java.util.*;
import java.io.*;
import java.math.*;

public class B {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		boolean allCheck = false;

		while (m-- > 0) {
			HashSet<Integer> table = new HashSet<Integer>();
			int count = input.nextInt();
			boolean check = true;

			for (int i = 0; i < count; i++)
				table.add(input.nextInt());

			for (int value : table)
				if (table.contains(-value)) {
					check = false;
					break;
				}

			if (check)
				allCheck = true;
		}

		System.out.print(allCheck ? "YES" : "NO");
	}
}