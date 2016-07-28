/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.29
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9372
 */

import java.util.Scanner;
import java.util.LinkedList;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int numberOfCases = input.nextInt(); // number of cases

		for (int testCase = 1; testCase <= numberOfCases; testCase++) {
			int numberOfCities = input.nextInt(); // vertex, number of cities
			int numberOfPilots = input.nextInt(); // edge, number of pilots

			// graph, initialization
			LinkedList<Integer>[] graph = (LinkedList<Integer>[]) new LinkedList[numberOfCities + 1];
			for (int i = 0; i <= numberOfCities; i++)
				graph[i] = new LinkedList<Integer>();

			// input graph
			for (int count = 1; count <= numberOfPilots; count++) {
				int firstVertex = input.nextInt();
				int secondVertex = input.nextInt();
				graph[firstVertex].add(secondVertex);
				graph[secondVertex].add(firstVertex);
			}

			// the minimum number of pilots that need to be trusted such that it is possible to travel between each pair of cities
			System.out.println(numberOfCities - 1);
		}
	}
}