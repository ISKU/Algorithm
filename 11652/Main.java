/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.28
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11652
 */

import java.util.Scanner;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Comparator;
import java.util.Map;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		HashMap<Long, Integer> table = new HashMap<Long, Integer>();
		int n = input.nextInt();

		while (n-- > 0) {
			long number = input.nextLong();
			table.put(number, table.containsKey(number) ? table.get(number) + 1 : 1);
		}

		TreeMap<Long, Integer> sort = new TreeMap<Long, Integer>(new Compare(table));
		sort.putAll(table);
		System.out.print(sort.firstKey());
	}

	private static class Compare implements Comparator<Long> {
		private Map<Long, Integer> map;

		public Compare(Map<Long, Integer> map) {
			this.map = map;
		}

		@Override
		public int compare(Long a, Long b) {
			if (map.get(a) < map.get(b))
				return 1;
			else if (map.get(a) > map.get(b))
				return -1;
			else
				return a.compareTo(b);
		}
	}
}