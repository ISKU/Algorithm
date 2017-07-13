/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.10
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10212
 */

import java.util.Random;

public class Main {
	public static void main(String... args) {
		if (new Random().nextInt() % 2 == 1)
			System.out.println("Korea");
		else
			System.out.println("Yonsei");
	}
}