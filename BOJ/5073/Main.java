/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.23
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5073
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			int[] tri = new int[] { input.nextInt(), input.nextInt(), input.nextInt() };
			if (tri[0] == 0 && tri[1] == 0 && tri[2] == 0)
				break;

			Arrays.sort(tri);
			if (tri[0] + tri[1] <= tri[2])
				System.out.println("Invalid");
			else if (tri[0] == tri[1] && tri[1] == tri[2])
				System.out.println("Equilateral");
			else if (tri[0] == tri[1] || tri[1] == tri[2] || tri[0] == tri[2])
				System.out.println("Isosceles");
			else
				System.out.println("Scalene");
		}
	}
}