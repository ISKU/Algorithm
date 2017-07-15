/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.04.07
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://code.google.com/codejam/contest/3264486/dashboard#s=p1
 */

import java.util.*;
import java.io.*;
import java.math.*;

public class B_Small {
	public static void main(String... args) throws IOException {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		for (int tCase = 1; tCase <= testCase; tCase++) {
			int number = input.nextInt();
			String[] split = String.valueOf(number).split("");

			OUT: while (true) {
				boolean check = false;
				String prev = split[0];
				for (int i = 1; i < split.length; i++) {
					if (Integer.parseInt(prev) <= Integer.parseInt(split[i]))
						prev = split[i];
					else {
						check = true;
						break;
					}
				}

				if (check) {
					number--;
					split = String.valueOf(number).split("");
				} else {
					boolean zero = false;
					for (int i = 0; i < split.length; i++)
						if (split[i] == "0") {
							zero = true;
							break;
						}

					if (zero) {
						number--;
						split = String.valueOf(number).split("");
					} else {
						break OUT;
					}
				}
			}

			System.out.printf("Case #%d: %d\n", tCase, number);
		}
	}
}