/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.24
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11586
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		String[] face = new String[input.nextInt()];

		for (int index = 0; index < face.length; index++)
			face[index] = input.next();

		int state = input.nextInt();
		if (state == 1) {
			for (int index = 0; index < face.length; index++)
				System.out.println(face[index]);
		} else if (state == 2) {
			for (int index = 0; index < face.length; index++) {
				for (int lineIndex = face[index].length() - 1; lineIndex >= 0; lineIndex--)
					System.out.print(face[index].charAt(lineIndex));
				System.out.println();
			}
		} else {
			for (int index = face.length - 1; index >= 0; index--)
				System.out.println(face[index]);
		}
	}
}