/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.06
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5596
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		String[] minkuk = input.nextLine().split(" ");
		String[] manse = input.nextLine().split(" ");
		int minkukGrade = 0;
		int manseGrade = 0;

		for (int count = 0; count < 4; count++) {
			minkukGrade += Integer.parseInt(minkuk[count]);
			manseGrade += Integer.parseInt(manse[count]);
		}

		System.out.println(Math.max(minkukGrade, manseGrade));
	}
}