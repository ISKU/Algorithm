/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.14
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11328
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			String[] first = input.next().split("");
			String[] second = input.next().split("");
			Arrays.sort(first);
			Arrays.sort(second);

			boolean check = true;
			if (first.length == second.length) {
				for (int i = 0; i < second.length; i++)
					if (!second[i].equals(first[i])) {
						check = false;
						break;
					}
			} else
				check = false;

			System.out.println(check ? "Possible" : "Impossible");
		}
	}
}