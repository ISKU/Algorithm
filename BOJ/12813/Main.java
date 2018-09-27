/*
 * Author: Minho Kim (ISKU)
 * Date: September 27, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/12813
 */

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] A = br.readLine().toCharArray();
		char[] B = br.readLine().toCharArray();

		for (int i = 0; i < A.length; i++)
			bw.write((A[i] == '1' & B[i] == '1') ? "1" : "0");
		bw.write("\n");

		for (int i = 0; i < A.length; i++)
			bw.write((A[i] == '1' | B[i] == '1') ? "1" : "0");
		bw.write("\n");

		for (int i = 0; i < A.length; i++)
			bw.write((A[i] == '1' ^ B[i] == '1') ? "1" : "0");
		bw.write("\n");

		for (int i = 0; i < A.length; i++)
			bw.write((A[i] == '1') ? "0" : "1");
		bw.write("\n");

		for (int i = 0; i < B.length; i++)
			bw.write((B[i] == '1') ? "0" : "1");
		bw.write("\n");

		bw.close();
	}
}