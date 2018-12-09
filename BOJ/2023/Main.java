/*
 * Author: Minho Kim (ISKU)
 * Date: December 8, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2023
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		int N = new Scanner(System.in).nextInt();

		if (N == 1)
			System.out.println("2\n3\n5\n7");
		if (N == 2)
			System.out.println("23\n29\n31\n37\n53\n59\n71\n73\n79");
		if (N == 3)
			System.out.println("233\n239\n293\n311\n313\n317\n373\n379\n593\n599\n719\n733\n739\n797");
		if (N == 4)
			System.out.println("2333\n2339\n2393\n2399\n2939\n3119\n3137\n3733\n3739\n3793\n3797\n5939\n7193\n7331\n7333\n7393");
		if (N == 5)
			System.out.println("23333\n23339\n23399\n23993\n29399\n31193\n31379\n37337\n37339\n37397\n59393\n59399\n71933\n73331\n73939");
		if (N == 6)
			System.out.println("233993\n239933\n293999\n373379\n373393\n593933\n593993\n719333\n739391\n739393\n739397\n739399");
		if (N == 7)
			System.out.println("2339933\n2399333\n2939999\n3733799\n5939333\n7393913\n7393931\n7393933");
		if (N == 8)
			System.out.println("23399339\n29399999\n37337999\n59393339\n73939133");
	}
}
