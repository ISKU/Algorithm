/*
 * Author: Minho Kim (ISKU)
 * Date: May 20, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17210
 */

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		int status = Integer.parseInt(br.readLine());

		if (N >= 6)
			System.out.print("Love is open door");
		else {
			for (int i = 1; i < N; i++)
				System.out.println(++status % 2);
		}
	}
}