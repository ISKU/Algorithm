/*
 * Author: Minho Kim (ISKU)
 * Date: May 29, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/987/A
 */

import java.io.*;

public class A {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] array = new int[6];

		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			String line = br.readLine();
			if (line.equals("purple"))
				array[0]++;
			if (line.equals("green"))
				array[1]++;
			if (line.equals("blue"))
				array[2]++;
			if (line.equals("orange"))
				array[3]++;
			if (line.equals("red"))
				array[4]++;
			if (line.equals("yellow"))
				array[5]++;
		}

		int count = 0;
		for (int i = 0; i < 6; i++)
			if (array[i] == 0)
				count++;

		System.out.println(count);
		if (array[0] == 0)
			System.out.println("Power");
		if (array[1] == 0)
			System.out.println("Time");
		if (array[2] == 0)
			System.out.println("Space");
		if (array[3] == 0)
			System.out.println("Soul");
		if (array[4] == 0)
			System.out.println("Reality");
		if (array[5] == 0)
			System.out.println("Mind");
	}
}