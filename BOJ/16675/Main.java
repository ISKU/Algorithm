/*
 * Author: Minho Kim (ISKU)
 * Date: December 10, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16675
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		char ml = sc.next().charAt(0);
		char mr = sc.next().charAt(0);
		char tl = sc.next().charAt(0);
		char tr = sc.next().charAt(0);

		if (win(ml, tl) && win(ml, tr))
			System.out.print("MS");
		else if (win(mr, tl) && win(mr, tr))
			System.out.print("MS");
		else if (win(tl, ml) && win(tl, mr))
			System.out.print("TK");
		else if (win(tr, ml) && win(tr, mr))
			System.out.print("TK");
		else
			System.out.print("?");
	}

	private static boolean win(char A, char B) {
		if (A == 'R' && B == 'S')
			return true;
		if (A == 'P' && B == 'R')
			return true;
		if (A == 'S' && B == 'P')
			return true;
		return false;
	}
}