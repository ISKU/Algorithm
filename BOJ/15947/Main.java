/*
 * Author: Minho Kim (ISKU)
 * Date: July 29, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15947
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		String[] song = new String[] { "baby", "sukhwan", "tururu", "turu", "very", "cute", "tururu", "turu", "in", "bed", "tururu", "turu", "baby", "sukhwan" };
		int N = new Scanner(System.in).nextInt();
		int p = (N - 1) / 14;
		int m = (N - 1) % 14;
		
		if (m == 0 || m == 1 || m == 4 || m == 5 || m == 8 || m == 9 || m == 12 || m == 13) {
			System.out.print(song[m]);
		}
		else if (m == 2 || m == 6 || m == 10) {
			if (p >= 3) {
				System.out.printf("tu+ru*%d", p + 2);
			} else {
				System.out.print(song[m]);
				for (int i = 0; i < p; i++)
					System.out.print("ru");
			}
		}
		else {
			if (p >= 4) {
				System.out.printf("tu+ru*%d", p + 1);
			} else {
				System.out.print(song[m]);
				for (int i = 0; i < p; i++)
					System.out.print("ru");
			}
		}
	}
}