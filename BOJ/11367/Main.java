/*
 * Author: Minho Kim (ISKU)
 * Date: June 22, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11367
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		while (N-- > 0) {
			String name = sc.next();
			int grade = sc.nextInt();
			System.out.printf("%s %s\n", name, get(grade));
		}
	}

	private static String get(int grade) {
		if (grade >= 97)
			return "A+";
		else if (grade >= 90)
			return "A";
		else if (grade >= 87)
			return "B+";
		else if (grade >= 80)
			return "B";
		else if (grade >= 77)
			return "C+";
		else if (grade >= 70)
			return "C";
		else if (grade >= 67)
			return "D+";
		else if (grade >= 60)
			return "D";
		else
			return "F";
	}
}