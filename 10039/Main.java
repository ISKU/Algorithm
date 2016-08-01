/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.01
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10039
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int sumOfGrade = 0;

		for (int student = 1; student <= 5; student++) {
			int currentStudentGrade = input.nextInt();
			sumOfGrade += currentStudentGrade >= 40 ? currentStudentGrade : 40;
		}

		System.out.println(sumOfGrade / 5); // average grade
	}
}