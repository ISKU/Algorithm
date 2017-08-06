/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.08.06
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14670
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int N = input.nextInt();
		while (N-- > 0)
			map.put(input.nextInt(), input.nextInt());

		int R = input.nextInt();
		while (R-- > 0) {
			StringBuilder answer = new StringBuilder();
			int L = input.nextInt();
			boolean check = false;

			for (int i = 0; i < L; i++) {
				int med = input.nextInt();
				if (map.containsKey(med))
					answer.append(map.get(med) + " ");
				else
					check = true;
			}

			System.out.println((check) ? "YOU DIED" : answer.toString());
		}
	}
}