/*
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.31
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10814
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		Member[] list = new Member[testCase];

		for (int index = 0; index < list.length; index++)
			list[index] = new Member(input.nextInt(), input.next());

		Arrays.sort(list);
		for (int index = 0; index < list.length; index++)
			System.out.println(list[index].age + " " + list[index].name);
	}

	private static class Member implements Comparable<Member> {
		public int age;
		public String name;

		public Member(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Member compare) {
			if (this.age < compare.age)
				return -1;
			else if (this.age > compare.age)
				return 1;
			else
				return 0;
		}
	}
}