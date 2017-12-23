/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.12.23
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15312
 */

import java.util.*;

public class Main {

	public static int[] letter = new int[] { 3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };
	public static ArrayList<ArrayList<Integer>> result;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		char[] A = input.nextLine().toCharArray();
		char[] B = input.nextLine().toCharArray();
		int size = A.length + B.length;

		result = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < size - 1; i++)
			result.add(new ArrayList<Integer>());

		for (int i = 0; i < A.length; i++) {
			result.get(0).add(letter[A[i] - 65]);
			result.get(0).add(letter[B[i] - 65]);
		}

		for (int i = 0; i < size - 2; i++)
			for (int j = 0; j < size - i - 1; j++)
				result.get(i + 1).add((result.get(i).get(j) % 10) + (result.get(i).get(j + 1) % 10));

		System.out.print((result.get(size - 2).get(0) % 10) + "" + (result.get(size - 2).get(1) % 10));
	}
}