/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.09.17
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14726
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();

		while (N-- > 0) {
			String[] number = input.next().split("");
			for (int i = 0; i < number.length; i += 2) {
				String[] digit = String
						.valueOf(Integer.parseInt(number[i]) * 2).split("");
				int digitNumber = 0;

				for (String d : digit)
					digitNumber += Integer.parseInt(d);
				number[i] = String.valueOf(digitNumber);
			}

			int answer = 0;
			for (String digit : number)
				answer += Integer.parseInt(digit);

			System.out.printf("%s\n", (answer % 10 == 0) ? "T" : "F");
		}
	}
}