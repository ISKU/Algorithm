/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.17
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14216
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int dimension = input.nextInt();
		int[][] cost = new int[dimension][dimension];

		for (int i = 0; i < dimension; i++)
			for (int j = 0; j < dimension; j++)
				cost[i][j] = input.nextInt();

		int[] result = new Hungarian(cost).run();
		int min = 0;
		for (int i = 0; i < dimension; i++)
			min += cost[i][result[i]];

		System.out.print(min);
	}

	private static class Hungarian {
		private final int[][] matrix;
		private final int dim;

		private final int[] labelWorker, labelJob;
		private final int[] slackWorker, slackJob;
		private final int[] matchJob, matchWorker;
		private final int[] parentWorker;
		private final boolean[] committed;

		public Hungarian(int[][] costMatrix) {
			dim = costMatrix.length;
			matrix = new int[dim][dim];

			labelWorker = new int[dim];
			labelJob = new int[dim];
			slackWorker = new int[dim];
			slackJob = new int[dim];
			committed = new boolean[dim];
			parentWorker = new int[dim];
			matchJob = new int[dim];
			matchWorker = new int[dim];

			Arrays.fill(matchJob, -1);
			Arrays.fill(matchWorker, -1);

			for (int i = 0; i < dim; i++)
				this.matrix[i] = Arrays.copyOf(costMatrix[i], dim);
		}

		public int[] run() {
			reduce();
			computeInitial();
			greedyMatch();

			int i = findUnmatchWorker();
			while (i < dim) {
				initializePhase(i);
				executePhase();
				i = findUnmatchWorker();
			}

			int[] result = Arrays.copyOf(matchJob, dim);
			for (i = 0; i < result.length; i++)
				if (result[i] >= dim)
					result[i] = -1;

			return result;
		}

		private void reduce() {
			for (int i = 0; i < dim; i++) {
				int min = Integer.MAX_VALUE;

				for (int j = 0; j < dim; j++)
					if (matrix[i][j] < min)
						min = matrix[i][j];

				for (int j = 0; j < dim; j++)
					matrix[i][j] -= min;
			}

			int[] min = new int[dim];
			Arrays.fill(min, Integer.MAX_VALUE);

			for (int i = 0; i < dim; i++)
				for (int j = 0; j < dim; j++)
					if (matrix[i][j] < min[j])
						min[j] = matrix[i][j];

			for (int i = 0; i < dim; i++)
				for (int j = 0; j < dim; j++)
					matrix[i][j] -= min[j];
		}

		private void computeInitial() {
			Arrays.fill(labelJob, Integer.MAX_VALUE);

			for (int i = 0; i < dim; i++)
				for (int j = 0; j < dim; j++)
					if (matrix[i][j] < labelJob[j])
						labelJob[j] = matrix[i][j];
		}

		protected void greedyMatch() {
			for (int i = 0; i < dim; i++)
				for (int j = 0; j < dim; j++)
					if (matchJob[i] == -1 && matchWorker[j] == -1 && matrix[i][j] - labelWorker[i] - labelJob[j] == 0)
						match(i, j);
		}

		private void executePhase() {
			while (true) {
				int minSlackWorker = -1, minSlackJob = -1;
				int minSlackValue = Integer.MAX_VALUE;

				for (int i = 0; i < dim; i++) {
					if (parentWorker[i] == -1) {
						if (slackJob[i] < minSlackValue) {
							minSlackValue = slackJob[i];
							minSlackWorker = slackWorker[i];
							minSlackJob = i;
						}
					}
				}

				if (minSlackValue > 0)
					updateLabel(minSlackValue);

				parentWorker[minSlackJob] = minSlackWorker;
				if (matchWorker[minSlackJob] == -1) {
					int committedJob = minSlackJob;
					int parent = parentWorker[committedJob];

					while (true) {
						int temp = matchJob[parent];
						match(parent, committedJob);
						committedJob = temp;

						if (committedJob == -1)
							break;

						parent = parentWorker[committedJob];
					}

					return;
				} else {
					int worker = matchWorker[minSlackJob];
					committed[worker] = true;

					for (int i = 0; i < dim; i++) {
						if (parentWorker[i] == -1) {
							int slack = matrix[worker][i] - labelWorker[worker] - labelJob[i];

							if (slackJob[i] > slack) {
								slackJob[i] = slack;
								slackWorker[i] = worker;
							}
						}
					}
				}
			}
		}

		protected int findUnmatchWorker() {
			int i;
			for (i = 0; i < dim; i++)
				if (matchJob[i] == -1)
					break;

			return i;
		}

		protected void initializePhase(int i) {
			Arrays.fill(committed, false);
			Arrays.fill(parentWorker, -1);
			committed[i] = true;

			for (int j = 0; j < dim; j++) {
				slackJob[j] = matrix[i][j] - labelWorker[i] - labelJob[j];
				slackWorker[j] = i;
			}
		}

		private void match(int i, int j) {
			matchJob[i] = j;
			matchWorker[j] = i;
		}

		protected void updateLabel(int slack) {
			for (int i = 0; i < dim; i++)
				if (committed[i])
					labelWorker[i] += slack;

			for (int i = 0; i < dim; i++) {
				if (parentWorker[i] != -1)
					labelJob[i] -= slack;
				else
					slackJob[i] -= slack;
			}
		}
	}
}