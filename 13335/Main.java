/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.23
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13335
 */

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int trucks = input.nextInt();
		int bridgeSize = input.nextInt();
		int boundary = input.nextInt();

		Queue<Integer> qTruck = new LinkedList<Integer>();
		for (int i = 0; i < trucks; i++)
			qTruck.add(input.nextInt());

		Queue<Integer> qBridge = new LinkedList<Integer>();
		for (int i = 0; i < bridgeSize; i++)
			qBridge.add(0);

		int curWeight = 0, count = 0, in = 0;
		while (trucks != in) {
			int curTruck = qTruck.isEmpty() ? 0 : qTruck.poll();

			if (curWeight + curTruck > boundary) {
				while (true) {
					int end = qBridge.poll();
					in = (end != 0) ? in + 1 : in;
					curWeight -= end;

					if (curWeight + curTruck <= boundary) {
						qBridge.add(curTruck);
						curWeight += curTruck;
						count++;
						break;
					} else
						qBridge.add(0);

					count++;
				}
			} else {

				int end = qBridge.poll();
				in = (end != 0) ? in + 1 : in;
				curWeight -= end;
				qBridge.add(curTruck);
				curWeight += curTruck;
				count++;
			}
		}

		System.out.println(count);
	}
}