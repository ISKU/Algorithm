/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.02
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2592
 */

import java.util.Scanner;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.PriorityQueue;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
		PriorityQueue<FrequencyNumber> frequencyHeap = new PriorityQueue<FrequencyNumber>();
		int sumOfNumber = 0;

		for (int count = 0; count < 10; count++) {
			int number = input.nextInt();
			table.put(number, table.containsKey(number) ? table.get(number) + 1 : 1);
		}

		Enumeration<Integer> keySet = table.keys();
		while (keySet.hasMoreElements()) {
			int key = keySet.nextElement();
			sumOfNumber = sumOfNumber + key * table.get(key);
			frequencyHeap.add(new FrequencyNumber(key, table.get(key)));
		}

		System.out.println(sumOfNumber / 10);
		System.out.println(frequencyHeap.poll().value);
	}

	private static class FrequencyNumber implements Comparable<FrequencyNumber> {
		public int value;
		public int frequency;

		public FrequencyNumber(int value, int frequency) {
			this.value = value;
			this.frequency = frequency;
		}

		@Override
		public int compareTo(FrequencyNumber compare) {
			if (this.frequency < compare.frequency)
				return 1;
			else if (this.frequency == compare.frequency)
				return 0;
			else
				return -1;
		}
	}
}