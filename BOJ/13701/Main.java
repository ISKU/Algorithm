/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.11.15
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13701
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Hashtable;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		Hashtable<String, Integer> table = new Hashtable<String, Integer>(5000000);

		while (parser.hasMoreTokens()) {
			String number = parser.nextToken();
			if (table.containsKey(number))
				continue;
			else
				table.put(number, 1);
			output.write(number + " ");
		}

		output.close();
	}
}
