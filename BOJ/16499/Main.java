/*
 * Author: Minho Kim (ISKU)
 * Date: November 16, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16499
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Set<String> set = new HashSet<>();
		while (N-- > 0) {
			char[] word = sc.next().toCharArray();
			Arrays.sort(word);
			set.add(String.valueOf(word));
		}

		System.out.print(set.size());
	}
}