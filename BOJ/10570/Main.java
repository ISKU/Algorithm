/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.08.06
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10570
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			int V = input.nextInt();
			while (V-- > 0) {
				int number = input.nextInt();
				map.put(number, map.containsKey(number) ? map.get(number) + 1 : 1);
			}

			ArrayList<Number> numbers = new ArrayList<Number>();
			for (int key : map.keySet())
				numbers.add(new Number(key, map.get(key)));

			Collections.sort(numbers, new Comparator<Number>() {
				@Override
				public int compare(Number A, Number B) {
					if (A.count < B.count)
						return 1;
					else if (A.count > B.count)
						return -1;
					else
						return A.number - B.number;
				}
			});
			
			System.out.println(numbers.get(0).number);
		}
	}

	private static class Number {
		public int number;
		public int count;

		public Number(int number, int count) {
			this.number = number;
			this.count = count;
		}
	}
}