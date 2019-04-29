/*
 * Author: Minho Kim (ISKU)
 * Date: August 22, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4774
 */

import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		BigDecimal sum = BigDecimal.ZERO;
		for (int i = 0; i < 12; i++)
			sum = sum.add(new BigDecimal(sc.next()));

		System.out.printf("$%s", sum.divide(new BigDecimal("12"), 2, BigDecimal.ROUND_HALF_UP));
	}
}