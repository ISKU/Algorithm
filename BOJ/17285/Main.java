/*
 * Author: Minho Kim (ISKU)
 * Date: June 30, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17285
 */

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] line = br.readLine().toCharArray();

		int key = 0;
		for (int i = 0; i < 128; i++) {
			if ((line[0] ^ i) == 'C') {
				key = i;
				break;
			}
		}

		for (int i = 0; i < line.length; i++)
			System.out.print((char) (line[i] ^ key));
	}
}