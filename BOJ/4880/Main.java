/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4880
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		while (true) {
			String line = input.nextLine();
			if (line.equals("0 0 0"))
				break;

			int ap[] = new int[2];
			int gp[] = new int[2];
			String[] number = line.split(" ");

			ap[0] = (Integer.parseInt(number[1]) - Integer.parseInt(number[0]));
			ap[1] = (Integer.parseInt(number[2]) - Integer.parseInt(number[1]));
			if (!number[0].equals("0") && !number[1].equals("0") && !number[2].equals("0")) {
				gp[0] = (Integer.parseInt(number[1]) / Integer.parseInt(number[0]));
				gp[1] = (Integer.parseInt(number[2]) / Integer.parseInt(number[1]));
			}

			if (ap[0] == ap[1])
				System.out.println("AP " + (Integer.parseInt(number[2]) + ap[1]));
			else
				System.out.println("GP " + (Integer.parseInt(number[2]) * gp[1]));
		}
	}
}