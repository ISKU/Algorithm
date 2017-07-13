/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.02
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10988
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		String[] word = input.next().split("");
		boolean isPalindrome = true;

		for (int front = 0, rear = word.length - 1; front <= rear; front++, rear--)
			if (word[front].equals(word[rear]) == false)
				isPalindrome = false;

		System.out.println(isPalindrome ? 1 : 0);
	}
}