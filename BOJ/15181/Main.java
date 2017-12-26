/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.12.27
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15181
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int[] code = new int[] { 0, 1, 2, 3, 4, 5, 6 };

		while (true) {
			char[] music = input.next().toCharArray();
			if (music[0] == '#')
				break;

			boolean check = true;
			for (int i = 0; i < music.length - 1; i++) {
				int count = 0;
				for (int start = code[music[i] - 65]; start != code[music[i + 1] - 65]; start = (start + 1) % 7)
					count++;

				if (count != 2 && count != 4 && count != 6) {
					check = false;
					break;
				}
			}

			System.out.println((check) ? "That music is beautiful." : "Ouch! That hurts my ears.");
		}
	}
}