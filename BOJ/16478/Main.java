/*
 * Author: Minho Kim (ISKU)
 * Date: November 21, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16478
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double pab = sc.nextDouble();
		double pbc = sc.nextDouble();
		double pcd = sc.nextDouble();
		System.out.printf("%.6f", pcd * pab / pbc);
	}
}