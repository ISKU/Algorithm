/* 
 * Author: Minho Kim (ISKU)
 * Date: 2018.01.02
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15279
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();

		while (N-- > 0) {
			double b = input.nextDouble();
			double p = input.nextDouble();
			double bpm = (b * 60) / p;
			double abpm = 60 / p;
			System.out.printf("%.4f %.4f %.4f\n", bpm - abpm, bpm, bpm + abpm);
		}
	}
}