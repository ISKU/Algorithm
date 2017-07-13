/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.14
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2857
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> array = new ArrayList<Integer>();

		for (int i = 0; i < 5; i++)
			if (input.nextLine().contains("FBI"))
				array.add(i + 1);

		if (array.size() == 0) {
			System.out.print("HE GOT AWAY!");
		} else {
			System.out.print(array.get(0));
			for (int i = 1; i < array.size(); i++)
				System.out.print(" " + array.get(i));
		}
	}
}