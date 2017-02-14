/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.14
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1620
 */

import java.util.Scanner;
import java.util.Hashtable;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		Hashtable<Integer, String> iDogam = new Hashtable<Integer, String>();
		Hashtable<String, Integer> sDogam = new Hashtable<String, Integer>();
		int pokets = input.nextInt();
		int querys = input.nextInt();

		for (int i = 0; i < pokets; i++) {
			String poketmon = input.next();
			iDogam.put(i + 1, poketmon);
			sDogam.put(poketmon, i + 1);
		}

		for (int i = 0; i < querys; i++) {
			String query = input.next();
			try {
				int index = Integer.parseInt(query);
				System.out.println(iDogam.get(index));
			} catch (Exception e) {
				System.out.println(sDogam.get(query));
			}
		}
	}
}