/*
 * Author: Minho Kim (ISKU)
 * Date: July 7, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17294
 */

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] number = br.readLine().toCharArray();
		if (number.length == 1) {
			System.out.println("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");
			System.exit(0);
		}

		int d = number[0] - number[1];
		for (int i = 1; i + 1 < number.length; i++) {
			if (d != number[i] - number[i + 1]) {
				System.out.println("흥칫뿡!! <(￣ ﹌ ￣)>");
				System.exit(0);
			}
		}

		System.out.println("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");
	}
}