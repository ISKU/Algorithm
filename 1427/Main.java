/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.31
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1427
 */

import java.util.Scanner;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		String[] number = input.next().split("");

		for (int index = 0; index < number.length; index++)
			queue.add(Integer.parseInt(number[index]));

		for (int count = 0; count < number.length; count++)
			System.out.print(queue.poll());
	}
}