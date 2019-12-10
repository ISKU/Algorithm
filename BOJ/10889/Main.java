/*
 * Author: Minho Kim (ISKU)
 * Date: December 9, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10889
 */

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());

		System.out.println((111 * x * x) + (11 * x) + 1);
	}
}
