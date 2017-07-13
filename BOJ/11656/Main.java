/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.08
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11656
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String... args) {
		String string = new Scanner(System.in).nextLine();
		ArrayList<String> array = new ArrayList<String>();

		for (int i = 0; i < string.length(); i++)
			array.add(string.substring(i, string.length()));

		Collections.sort(array, (a, b) -> {
			return a.compareTo(b);
		});

		for (String word : array)
			System.out.println(word);
	}
}