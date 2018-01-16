/*
 * Author: Minho Kim (ISKU)
 * Date: January 16, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10974
 */

import java.util.*;

public class Main {

	private static int N;

	public static void main(String... args) {
		N = new Scanner(System.in).nextInt();
		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++)
			array.add(i);

		run(array, "", 0);
	}

	private static void run(ArrayList<Integer> array, String result, int step) {
		if (step == N) {
			System.out.println(result);
			return;
		}

		for (int number : array) {
			ArrayList<Integer> temp = (ArrayList<Integer>) array.clone();
			temp.remove(Integer.valueOf(number));
			run(temp, result + number + " ", step + 1);
		}
	}
}