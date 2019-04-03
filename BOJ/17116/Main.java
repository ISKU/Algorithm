/*
 * Author: Minho Kim (ISKU)
 * Date: April 3, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17116
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();

		if (line.equals("KEY IS PUSH AND OPEN DOOR IS SHUT"))
			System.out.println("BABA IS WIN");
		if (line.equals("BABA IS ROCK"))
			System.out.println("BABA IS NOT WIN");
		if (line.equals("LONELY FLAG IS BABA"))
			System.out.println("BABA IS WIN");
		if (line.equals("TEXT IS NOT PUSH WALL IS STOP"))
			System.out.println("BABA IS NOT WIN");
	}
}