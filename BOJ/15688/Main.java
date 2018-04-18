/*
 * Author: Minho Kim (ISKU)
 * Date: April 17, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15688
 */

import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = parseInt(br.readLine());

		int[] array = new int[2000001];
		while (N-- > 0)
			array[parseInt(br.readLine()) + 1000000]++;

		for (int i = 0; i < 2000001; i++)
			while (array[i]-- > 0)
				bw.write(i - 1000000 + "\n");
		bw.close();
	}

	private static int parseInt(String s) {
		int negative = 0;
		if (s.charAt(0) == '-')
			negative++;

		int result = 0;
		for (int i = s.length() - 1, d = 1; i >= negative; i--, d *= 10)
			result += d * (s.charAt(i) - '0');

		return (negative == 1) ? -result : result;
	}
}