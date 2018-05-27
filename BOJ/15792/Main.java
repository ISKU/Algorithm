/*
 * Author: Minho Kim (ISKU)
 * Date: May 24, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15792
 */

import java.util.*;
import java.math.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		System.out.print(new BigDecimal(sc.next()).divide(new BigDecimal(sc.next()), 1001, BigDecimal.ROUND_HALF_UP));
	}
}