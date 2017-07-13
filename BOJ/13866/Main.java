/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.12.15
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13866
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] skill = new int[] { input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt() };
		int value = Integer.MAX_VALUE;

		value = Math.min(Math.abs((skill[0] + skill[1]) - (skill[2] + skill[3])), value);
		value = Math.min(Math.abs((skill[0] + skill[3]) - (skill[1] + skill[2])), value);
		value = Math.min(Math.abs((skill[0] + skill[2]) - (skill[1] + skill[3])), value);

		System.out.print(value);
	}
}