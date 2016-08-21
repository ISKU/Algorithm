/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.21
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5597
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		boolean[] attendanceRecord = new boolean[31];

		for (int count = 0; count < 28; count++)
			attendanceRecord[input.nextInt()] = true;

		for (int index = 1; index <= 30; index++)
			if (!attendanceRecord[index])
				System.out.println(index);
	}
}