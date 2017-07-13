/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.16
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9536
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = Integer.parseInt(input.nextLine());

		while (testCase-- > 0) {
			String[] sayAll = input.nextLine().split(" ");

			while (true) {
				String animal = input.nextLine();
				if (animal.equals("what does the fox say?"))
					break;

				String say = animal.split(" ")[2];
				for (int i = 0; i < sayAll.length; i++)
					if (sayAll[i].equals(say))
						sayAll[i] = "";
			}

			for (int i = 0; i < sayAll.length; i++)
				if (!sayAll[i].equals(""))
					System.out.print(sayAll[i] + " ");
		}
	}
}