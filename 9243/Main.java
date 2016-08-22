/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.22
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9243
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		String previousFile = input.next();
		String deleteFile = input.next();
		boolean checkDeletion = true;

		if (N % 2 == 1) {
			for (int index = 0; index < deleteFile.length(); index++)
				if (previousFile.charAt(index) == deleteFile.charAt(index)) {
					checkDeletion = false;
					break;
				}
		} else {
			for (int index = 0; index < deleteFile.length(); index++)
				if (previousFile.charAt(index) != deleteFile.charAt(index)) {
					checkDeletion = false;
					break;
				}
		}

		System.out.print(checkDeletion ? "Deletion succeeded" : "Deletion failed");
	}
}