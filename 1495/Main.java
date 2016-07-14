/*
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.07
 * email: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1495 
 */

import java.util.Scanner;

public class Main {
	private static String inputVolumeList[];
	private static int TABLE[][];
	private static int NUMBER, MAX, MIN = 0;

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		// input first line, initialization
		String[] inputFirstLine = (input.nextLine()).split(" ");
		NUMBER = Integer.parseInt(inputFirstLine[0]); // 1, number of Songs
		int init = Integer.parseInt(inputFirstLine[1]); // 2, initial value
		MAX = Integer.parseInt(inputFirstLine[2]); // 3, max-boundary

		// table initialization: -1
		TABLE = new int[NUMBER + 1][MAX + 1];
		for (int i = 0; i < NUMBER + 1; i++)
			for (int j = 0; j < MAX + 1; j++)
				TABLE[i][j] = -1;

		// input second line, Volume List V[i]
		inputVolumeList = (input.nextLine()).split(" ");
		System.out.println(find(0, init)); // recursive call. output
	}

	private static int find(int index, int current) {
		if (TABLE[index][current] != -1) // already calculated
			return TABLE[index][current];
		if (index == NUMBER) // end
			return current;

		// calculate
		int plusVolume = -1, minusVolume = -1;	// when the output of the impossible: -1
		int volume = Integer.parseInt(inputVolumeList[index]);
		int plusResult = current + volume;
		int minusResult = current - volume;

		// value exceeds the maximum range
		if (plusResult <= MAX) { 
			plusVolume = find(index + 1, plusResult);
			if (plusVolume == -1)
				TABLE[index + 1][plusResult] = Integer.MIN_VALUE;
		}
		
		// minimum-boundary: 0
		if (minusResult >= MIN) { 
			minusVolume = find(index + 1, minusResult);
			if (minusVolume == -1)
				TABLE[index + 1][minusResult] = Integer.MIN_VALUE;
		}

		TABLE[index][current] = Math.max(plusVolume, minusVolume);	// current maximum value
		return TABLE[index][current];	// maximum value. output
	}
}