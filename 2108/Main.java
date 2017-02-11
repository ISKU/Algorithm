/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.11
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2108
 */

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int[] array = new int[input.nextInt()];
		int[] freq = new int[8001];
		float sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < array.length; i++) {
			array[i] = input.nextInt();
			sum += array[i];
			freq[array[i] + 4000]++;
			max = Math.max(max, array[i]);
			min = Math.min(min, array[i]);
		}

		ArrayList<Integer> rFreq = new ArrayList<Integer>();
		int vFreq = freq[0];
		for (int i = 0; i < freq.length; i++)
			vFreq = Math.max(vFreq, freq[i]);

		for (int i = 0; i < freq.length; i++)
			if (vFreq == freq[i])
				rFreq.add(i);

		int[] copy = array.clone();
		Arrays.sort(copy);
		Collections.sort(rFreq);

		System.out.printf("%.0f\n", sum / array.length);
		System.out.println(copy[array.length / 2]);
		System.out.println(rFreq.size() >= 2 ? rFreq.get(1) - 4000 : rFreq.get(0) - 4000);
		System.out.println(max - min);
	}
}