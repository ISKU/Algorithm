/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.09.28
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14729
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		double[] grade = new double[Integer.parseInt(input.readLine())];
		
		for (int i = 0; i < grade.length; i++)
			grade[i] = Double.parseDouble(input.readLine());
		Arrays.sort(grade);

		for (int i = 0; i < 7; i++)
			System.out.printf("%.3f\n", grade[i]);
	}
}