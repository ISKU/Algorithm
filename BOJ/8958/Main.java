/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.06
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/8958
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		for (int testCase = input.nextInt(); testCase > 0; testCase--) {
			String[] grade = input.next().split("");
			int totalGrade = 0;
			int savePreviousGrade = 0;
			for (int index = 0; index < grade.length; index++) {
				if (grade[index].equals("O")) {
					savePreviousGrade++;
					totalGrade += savePreviousGrade;
				} else
					savePreviousGrade = 0;
			}
			System.out.println(totalGrade);
		}
	}
}