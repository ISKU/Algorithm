/*
 * Author: Minho Kim (ISKU)
 * Date: December 2, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1436
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 666; list.size() <= 10000; i++)
			if (String.valueOf(i).contains("666"))
				list.add(i);

		System.out.print(list.get(new Scanner(System.in).nextInt() - 1));
	}
}