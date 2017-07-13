/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9933
 */

import java.util.Scanner;
import java.util.Hashtable;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Hashtable<String, Integer> table = new Hashtable<String, Integer>();
		int N = input.nextInt();

		while (N-- > 0) {
			String psw = input.next();
			table.put(psw, 0);
			if (table.containsKey(new StringBuilder(psw).reverse().toString())) {
				System.out.print(psw.length() + " " + psw.charAt(psw.length() / 2));
				break;
			}
		}
	}
}