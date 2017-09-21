/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.09.17
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14717
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		HashMap<String, Integer> genealogy = new HashMap<String, Integer>() {{
			put("1010", 1);
			put("99", 2);
			put("88", 3);
			put("77", 4);
			put("66", 5);
			put("55", 6);
			put("44", 7);
			put("33", 8);
			put("22", 9);
			put("11", 10);
			put("9", 11);
			put("8", 12);
			put("7", 13);
			put("6", 14);
			put("5", 15);
			put("4", 16);
			put("3", 17);
			put("2", 18);
			put("1", 19);
			put("0", 20);
		}};

		ArrayList<String> cards = new ArrayList<String>();
		for (int i = 1; i <= 10; i++) {
			cards.add(String.valueOf(i));
			cards.add(String.valueOf(i));
		}

		int first = input.nextInt();
		int second = input.nextInt();
		int me = 0;
		if (first == second)
			me = genealogy.get(String.valueOf(first) + String.valueOf(second));
		else
			me = genealogy.get(String.valueOf((first + second) % 10));

		cards.remove(String.valueOf(first));
		cards.remove(String.valueOf(second));
		int count = 0;

		for (int i = 0; i < cards.size(); i++) {
			for (int j = i + 1; j < cards.size(); j++) {
				int priority = 0;
				if (cards.get(i).equals(cards.get(j)))
					priority = genealogy.get(cards.get(i) + cards.get(j));
				else
					priority = genealogy.get(String.valueOf(
							(Integer.parseInt(cards.get(i)) + Integer.parseInt(cards.get(j))) % 10));

				if (priority > me)
					count++;
			}
		}

		System.out.printf("%.3f", (double) count / 153);
	}
}