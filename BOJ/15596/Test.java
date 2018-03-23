/*
 * Author: Minho Kim (ISKU)
 * Date: March 23, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15596
 */

public class Test {
    long sum(int[] a) {
        long ans = 0;
        for (int i = 0; i < a.length; i++)
            ans += a[i];
        return ans;
    }
}
