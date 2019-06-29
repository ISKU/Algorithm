/*
 * Author: Minho Kim (ISKU)
 * Date: June 29, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17284
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] buttons = new int[] { 0, 500, 800, 1000 };
		int money = 5000;
		while (st.hasMoreTokens())
			money -= buttons[Integer.parseInt(st.nextToken())];

		System.out.print(money);
	}
}