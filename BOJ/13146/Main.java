/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.22
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13146
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {

	private static long minimumValue = 0;

	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		LinkedBlockingDeque<Integer> deque = new LinkedBlockingDeque<Integer>();
		int maxSize = Integer.parseInt(input.readLine());

		for (int count = 0; count < maxSize; count++) {
			int number = Integer.parseInt(input.readLine());

			if (deque.isEmpty())
				deque.push(number);
			else {
				int previousNumber = deque.peek();

				while (true) {
					if (previousNumber < number) {
						int firstNumber = deque.pop();
						if (deque.size() != 0 && deque.peek() < number)
							minimumValue += deque.peek() - firstNumber;
						else {
							minimumValue += number - firstNumber;
							break;
						}
					} else
						break;
				}

				deque.push(number);
			}
		}

		if (deque.size() > 1)
			minimumValue += deque.pollLast() - deque.pop();
		System.out.println(minimumValue);
	}
}