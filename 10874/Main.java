/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10874
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		String answer = "1 2 3 4 5 1 2 3 4 5";
		int testCase = Integer.parseInt(input.nextLine());

		for (int student = 1; student <= testCase; student++)
			if (input.nextLine().equals(answer))
				System.out.println(student);
	}
}