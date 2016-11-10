/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.11.10
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13567
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String... args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		int limit = Integer.parseInt(parser.nextToken());
		int testCase = Integer.parseInt(parser.nextToken());
		int x = 0, y = 0;
		boolean turn = true;
		boolean coordinate = true;
		boolean complete = true;

		for (int index = 0; index < testCase; index++) {
			parser = new StringTokenizer(input.readLine());
			String command = parser.nextToken();
			int move = Integer.parseInt(parser.nextToken());

			if (command.equals("MOVE")) {
				if (coordinate) {
					if (turn)
						x += move;
					else
						x -= move;
				} else {
					if (turn)
						y += move;
					else
						y -= move;
				}
			} else {
				if (move == 0) {
					if (coordinate && turn) {
						coordinate = false;
						turn = true;
					} else if (!coordinate && turn) {
						coordinate = true;
						turn = false;
					} else if (coordinate && !turn) {
						coordinate = false;
						turn = false;
					} else if (!coordinate && !turn) {
						coordinate = true;
						turn = true;
					}
				} else {
					if (coordinate && turn) {
						coordinate = false;
						turn = false;
					} else if (!coordinate && turn) {
						coordinate = true;
						turn = true;
					} else if (coordinate && !turn) {
						coordinate = false;
						turn = true;
					} else if (!coordinate && !turn) {
						coordinate = true;
						turn = false;
					}
				}
			}

			if (x < 0 || x > limit || y < 0 || y > limit) {
				complete = false;
				break;
			}
		}

		System.out.println(complete ? x + " " + y : -1);
	}
}