/*
 * Author: Minho Kim (ISKU)
 * Date: June 28, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17283
 */

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long L = Integer.parseInt(br.readLine());
		double R = Integer.parseInt(br.readLine());

		long sum = 0;
		L = (long) (L * (R / 100));
		for (long i = 2; L > 5; i <<= 1) {
			sum += L * i;
			L = (long) (L * (R / 100));
		}

		System.out.print(sum);
	}
}