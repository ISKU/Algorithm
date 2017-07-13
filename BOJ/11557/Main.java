/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.31
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11557
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		for (int testCase = input.nextInt(); testCase > 0; testCase--) {
			int numberOfSchools = input.nextInt();
			School[] school = new School[numberOfSchools];
			input.nextLine();
			for (int count = 0; count < numberOfSchools; count++) {
				String[] schoolInformation = input.nextLine().split(" ");
				school[count] = new School(schoolInformation[0], Integer.parseInt(schoolInformation[1]));
			}
			Arrays.sort(school);
			System.out.println(school[0].name);
		}
	}

	private static class School implements Comparable<School> {
		public String name;
		public int alcoholConsumption;

		public School(String name, int alcoholConsumption) {
			this.name = name;
			this.alcoholConsumption = alcoholConsumption;
		}

		@Override
		public int compareTo(School compare) {
			if (this.alcoholConsumption < compare.alcoholConsumption)
				return 1;
			else if (this.alcoholConsumption == compare.alcoholConsumption)
				return 0;
			else
				return -1;
		}
	}
}