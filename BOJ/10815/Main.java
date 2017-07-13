/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.12.08
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10815
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Hashtable;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer parser = new StringTokenizer(input.readLine());
		Hashtable<String, Integer> table = new Hashtable<String, Integer>();

		int count = Integer.parseInt(parser.nextToken());
		parser = new StringTokenizer(input.readLine());
		while (count-- > 0)
			table.put(parser.nextToken(), 1);

		parser = new StringTokenizer(input.readLine());
		count = Integer.parseInt(parser.nextToken());
		parser = new StringTokenizer(input.readLine());
		while (count-- > 0) {
			String number = parser.nextToken();
			System.out.print(table.containsKey(number) ? "1 " : "0 ");
		}
	}
}