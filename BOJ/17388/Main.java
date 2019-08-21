/*
 * Author: Minho Kim (ISKU)
 * Date: August 21, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17388
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Object[][] array = new Object[3][];
		int soongsil = 0;
		int korea = 0;
		int hanyang = 0;
		array[0] = new Object[] { soongsil = sc.nextInt(), "Soongsil" };
		array[1] = new Object[] { korea = sc.nextInt(), "Korea" };
		array[2] = new Object[] { hanyang = sc.nextInt(), "Hanyang" };

		Arrays.sort(array, new Comparator<Object[]>() {
			@Override
			public int compare(Object[] o1, Object[] o2) {
				return Integer.compare((int) o1[0], (int) o2[0]);
			}
		});

		System.out.println((soongsil + korea + hanyang >= 100) ? "OK" : array[0][1]);
	}
}