/*
 * Author: Minho Kim (ISKU)
 * Date: February 04, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13118
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] man = new int[4];
		for (int i = 0; i < 4; i++)
			man[i] = sc.nextInt();

		int x = sc.nextInt();
		int answer = 0;
		for (int i = 0; i < 4; i++)
			if (man[i] == x)
				answer = i + 1;

		System.out.print(answer);
	}
}