/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11609
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Name[] AttendanceBook = new Name[input.nextInt()];

		for (int index = 0; index < AttendanceBook.length; index++)
			AttendanceBook[index] = new Name(input.next(), input.next());

		Arrays.sort(AttendanceBook);
		for (int index = 0; index < AttendanceBook.length; index++)
			System.out.println(AttendanceBook[index].firstName + " " + AttendanceBook[index].lastName);
	}

	private static class Name implements Comparable<Name> {
		public String firstName;
		public String lastName;

		public Name(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		@Override
		public int compareTo(Name compare) {
			if (this.lastName.compareTo(compare.lastName) > 0)
				return 1;
			else if (this.lastName.compareTo(compare.lastName) < 0)
				return -1;
			else {
				if (this.firstName.compareTo(compare.firstName) > 0)
					return 1;
				else if (this.firstName.compareTo(compare.firstName) < 0)
					return -1;
				else
					return 0;
			}
		}
	}
}