/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.22
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11101
 */

import java.util.Scanner;
import java.util.Hashtable;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		for (int testCase = Integer.parseInt(input.nextLine()); testCase > 0; testCase--) {
			Hashtable<String, Integer> table = new Hashtable<String, Integer>();
			int minimumTime = Integer.MAX_VALUE;

			String[] firstLine = input.nextLine().split(",");
			for (int index = 0; index < firstLine.length; index++) {
				String[] keySet = firstLine[index].split(":");
				table.put(keySet[0], Integer.parseInt(keySet[1]));
			}

			String[] secondLine = input.nextLine().split("[|]");
			for (int index = 0; index < secondLine.length; index++) {
				String[] combination = secondLine[index].split("&");
				int currentMaxValue = 0;

				for (int count = 0; count < combination.length; count++)
					currentMaxValue = Math.max(currentMaxValue, table.get(combination[count]));

				minimumTime = Math.min(currentMaxValue, minimumTime);
			}
			
			System.out.println(minimumTime);
		}
	}
}