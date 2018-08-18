/*
 * Author: Minho Kim (ISKU)
 * Date: August 14, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15965
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		boolean[] prime = new boolean[8000000];
		for (int i = 2; i * i < 8000000; i++)
			if (!prime[i])
				for (int j = i * i; j < 8000000; j += i)
					prime[j] = true;

		ArrayList<Integer> seq = new ArrayList<>();
		for (int i = 1; i < 8000000; i++)
			if (!prime[i])
				seq.add(i);

		System.out.print(seq.get(new Scanner(System.in).nextInt()));
	}
}