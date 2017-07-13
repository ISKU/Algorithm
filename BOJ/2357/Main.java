/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.28
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2357
 */

import java.util.Scanner;

public class Main {

	private static final int MAX = 1000000001;
	private static final int MIN = -1;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		int queries = input.nextInt();
		int[] elements = new int[size];

		for (int index = 0; index < size; index++)
			elements[index] = input.nextInt();

		SegmentTree segmentTree = new SegmentTree(size);
		segmentTree.build(elements);

		while (queries-- > 0) {
			int startIndex = input.nextInt() - 1;
			int endIndex = input.nextInt() - 1;
			System.out.println(segmentTree.getMin(startIndex, endIndex) 
											+ " " + segmentTree.getMax(startIndex, endIndex));
		}
	}

	private static class SegmentTree {

		private final int HEAD = 0;
		private final int START = 0;
		private final int END;

		private int[] minTree;
		private int[] maxTree;
		private int height;
		private int nodes;

		public SegmentTree(int size) {
			height = (int) (Math.ceil(Math.log(size) / Math.log(2)));
			nodes = 2 * (int) Math.pow(2, height) - 1;
			minTree = new int[nodes];
			maxTree = new int[nodes];
			END = size - 1;
		}

		public void build(int[] elements) {
			buildMinTree(elements, START, END, HEAD);
			buildMaxTree(elements, START, END, HEAD);
		}

		public int getMin(int queryStart, int queryEnd) {
			return getMinTree(START, END, queryStart, queryEnd, HEAD);
		}

		public int getMax(int queryStart, int queryEnd) {
			return getMaxTree(START, END, queryStart, queryEnd, HEAD);
		}

		private int buildMinTree(int[] elements, int startIndex, int endIndex, int current) {
			if (startIndex == endIndex) {
				minTree[current] = elements[startIndex];
				return minTree[current];
			}

			int mid = mid(startIndex, endIndex);
			minTree[current] = Math.min(buildMinTree(elements, startIndex, mid, left(current)),
					buildMinTree(elements, mid + 1, endIndex, right(current)));
			return minTree[current];
		}

		private int buildMaxTree(int[] elements, int startIndex, int endIndex, int current) {
			if (startIndex == endIndex) {
				maxTree[current] = elements[startIndex];
				return maxTree[current];
			}

			int mid = mid(startIndex, endIndex);
			maxTree[current] = Math.max(buildMaxTree(elements, startIndex, mid, left(current)),
					buildMaxTree(elements, mid + 1, endIndex, right(current)));
			return maxTree[current];
		}

		private int getMinTree(int startIndex, int endIndex, int queryStart, int queryEnd, int current) {
			if (queryStart <= startIndex && queryEnd >= endIndex)
				return minTree[current];

			if (endIndex < queryStart || startIndex > queryEnd)
				return MAX;

			int mid = mid(startIndex, endIndex);
			return Math.min(getMinTree(startIndex, mid, queryStart, queryEnd, left(current)),
					getMinTree(mid + 1, endIndex, queryStart, queryEnd, right(current)));
		}

		private int getMaxTree(int startIndex, int endIndex, int queryStart, int queryEnd, int current) {
			if (queryStart <= startIndex && queryEnd >= endIndex)
				return maxTree[current];

			if (endIndex < queryStart || startIndex > queryEnd)
				return MIN;

			int mid = mid(startIndex, endIndex);
			return Math.max(getMaxTree(startIndex, mid, queryStart, queryEnd, left(current)),
					getMaxTree(mid + 1, endIndex, queryStart, queryEnd, right(current)));
		}

		private int left(int parent) {
			return 2 * parent + 1;
		}

		private int right(int parent) {
			return 2 * parent + 2;
		}

		private int mid(int start, int end) {
			return (start + (end - start) / 2);
		}
	}
}