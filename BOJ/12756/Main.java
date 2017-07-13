/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/12756
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int damageOfPlayerA = input.nextInt();
		int lifeOfPlayerA = input.nextInt();
		int damageOfPlayerB = input.nextInt();
		int lifeOfPlayerB = input.nextInt();

		while (true) {
			lifeOfPlayerA -= damageOfPlayerB;
			lifeOfPlayerB -= damageOfPlayerA;

			if (lifeOfPlayerA <= 0 && lifeOfPlayerB <= 0) {
				System.out.println("DRAW");
				break;
			} else {
				if (lifeOfPlayerA > 0 && lifeOfPlayerB <= 0) {
					System.out.println("PLAYER A");
					break;
				}
				if (lifeOfPlayerA <= 0 && lifeOfPlayerB > 0) {
					System.out.println("PLAYER B");
					break;
				}
			}
		}
	}
}