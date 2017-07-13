/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.03
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10886
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int answer = 0;

		for (int count = input.nextInt(); count > 0; count--)
			answer = input.nextInt() == 1 ? answer + 1 : answer - 1;

		System.out.println(answer < 0 ? "Junhee is not cute!" : "Junhee is cute!");
	}
}