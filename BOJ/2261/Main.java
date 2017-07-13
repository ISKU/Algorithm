/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.10.22
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2261
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String... args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		Point points[] = new Point[Integer.parseInt(parser.nextToken())];

		for (int index = 0; index < points.length; index++) {
			parser = new StringTokenizer(input.readLine());
			points[index] = new Point(Integer.parseInt(parser.nextToken()), Integer.parseInt(parser.nextToken()));
		}

		quickSort(points, 0, points.length - 1, true);
		int smallestDistance = closestPair(points, 0, points.length - 1);
		System.out.println((smallestDistance == Integer.MAX_VALUE) ? 0 : smallestDistance);
	}

	private static int closestPair(Point[] array, int start, int end) {
		int delta = Integer.MAX_VALUE;
		int length = end - start + 1;

		if (length <= 2)
			return distance(array[start], array[end]);

		int mid = (start + end) / 2;
		int alpha = closestPair(array, start, mid);
		int beta = closestPair(array, mid + 1, end);
		delta = Math.min(alpha, beta);

		int lengthOfBand = 0;
		Point[] band = new Point[length];
		for (int index = start; index <= end; index++)
			if (square(array[index].x - array[mid].x) <= delta)
				band[lengthOfBand++] = array[index];

		quickSort(band, 0, lengthOfBand - 1, false);

		for (int i = 0; i < lengthOfBand; i++) {
			for (int j = i + 1; j < i + 12 && j < lengthOfBand; j++) {
				int tempDistance = distance(band[i], band[j]);

				if (tempDistance < delta) {
					delta = tempDistance;
					break;
				}
			}
		}

		return delta;
	}

	private static int distance(Point first, Point second) {
		int distance = square(first.x - second.x) + square(first.y - second.y);
		return (distance == 0) ? Integer.MAX_VALUE : distance;
	}

	private static int square(int x) {
		return x * x;
	}

	private static void quickSort(Point[] array, int low, int high, boolean coordinate) {
		if (array == null || array.length == 0)
			return;
		if (low >= high)
			return;

		int middle = low + (high - low) / 2;
		int pivot = coordinate ? array[middle].x : array[middle].y;
		int i = low, j = high;

		while (i <= j) {
			while ((coordinate ? array[i].x : array[i].y) < pivot)
				i++;
			while ((coordinate ? array[j].x : array[j].y) > pivot)
				j--;

			if (i <= j) {
				Point temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}

		if (low < j)
			quickSort(array, low, j, coordinate);
		if (high > i)
			quickSort(array, i, high, coordinate);
	}

	private static class Point {
		public int x;
		public int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}