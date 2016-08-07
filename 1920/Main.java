/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.08
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1920
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
		Hashtable<String, Integer> hashTable = new Hashtable<String, Integer>(100000); // no rehash
		int arrayMaxSize = Integer.parseInt(input.readLine());

		// input, array
		StringTokenizer parser = new StringTokenizer(input.readLine());
		for (int index = 0; index < arrayMaxSize; index++)
			hashTable.put(parser.nextToken(), 1);

		// output, contains number
		int maxCount = Integer.parseInt(input.readLine());
		parser = new StringTokenizer(input.readLine());
		for (int count = 0; count < maxCount; count++)
			output.append(hashTable.containsKey(parser.nextToken()) ? 1 + "\n" : 0 + "\n");

		System.out.print(output);
	}
}