/*
 * Author: Minho Kim (ISKU)
 * Date: July 20, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15917
 */

import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int Q = Integer.parseInt(br.readLine());
		while (Q-- > 0) {
			int a = Integer.parseInt(br.readLine());
			bw.write(((a & -a) == a) ? "1\n" : "0\n");
		}

		bw.close();
	}
}