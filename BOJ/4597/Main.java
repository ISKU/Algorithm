/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.22
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4597
 */

import java.util.Scanner;
import java.util.Hashtable;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		while (true) {
			Hashtable<String, Integer> table = new Hashtable<String, Integer>();
			table.put("1", 0);
			table.put("0", 0);
			String[] binaryNumber = input.nextLine().split("");
			if (binaryNumber[0].equals("#"))
				break;

			for (int index = 0; index < binaryNumber.length - 1; index++) {
				String currentBit = binaryNumber[index];
				table.put(currentBit, table.get(currentBit) + 1);
				System.out.print(currentBit);
			}
			if (binaryNumber[binaryNumber.length - 1].equals("e")) {
				if (table.get("1") % 2 == 0)
					System.out.println("0");
				else
					System.out.println("1");
			} else {
				if (table.get("1") % 2 == 1)
					System.out.println("0");
				else
					System.out.println("1");
			}
		}

	}
}