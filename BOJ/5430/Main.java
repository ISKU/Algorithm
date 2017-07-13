/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.05
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5430
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			char[] command = input.next().toCharArray();
			int size = input.nextInt();
			ArrayList<Integer> array = new ArrayList<Integer>();
			String[] value = input.next().replaceAll("\\[|\\]", "").split(",");

			for (int i = 0; i < size; i++)
				array.add(Integer.parseInt(value[i]));

			boolean reverse = true;
			boolean check = false;
			for (int i = 0; i < command.length; i++) {
				if (command[i] == 'R')
					reverse = !reverse;

				if (command[i] == 'D') {
					if (array.size() != 0) {
						if (reverse)
							array.remove(0);
						else
							array.remove(array.size() - 1);
					} else {
						check = true;
						break;
					}
				}
			}

			if (check)
				System.out.println("error");
			else {
				if (reverse) {
					System.out.print("[" + (array.size() != 0 ? array.get(0) : ""));
					for (int i = 1; i < array.size(); i++)
						System.out.print("," + array.get(i));
				} else {
					System.out.print("[" + (array.size() != 0 ? array.get(array.size() - 1) : ""));
					for (int i = array.size() - 2; i >= 0; i--)
						System.out.print("," + array.get(i));
				}
				System.out.println("]");
			}
		}
	}
}