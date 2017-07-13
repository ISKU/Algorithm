/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.28
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1181
 */

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		HashMap<String, Integer> words = new HashMap<String, Integer>();
		ArrayList<String> array = new ArrayList<String>();

		for (int i = 0; i < N; i++)
			words.put(input.next(), 1);

		array.addAll(words.keySet());
		Collections.sort(array, (a, b) -> {
			if (a.length() < b.length())
				return -1;
			else if (a.length() > b.length())
				return 1;
			else
				return a.compareTo(b);
		});

		for (int i = 0; i < array.size(); i++)
			System.out.println(array.get(i));
	}
}