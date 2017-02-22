/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.23
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10833
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int count = input.nextInt();
		int sum = 0;

		while (count-- > 0) {
			int students = input.nextInt();
			int apples = input.nextInt();
			sum += apples % students;
		}

		System.out.println(sum);
	}
}