/*
 * Author: Minho Kim (ISKU)
 * Date: May 3, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1780
 */

import java.util.*;
import java.io.*;

public class Main {

    private static int[][] paper;
    private static int[] answer;

    public static void main(String... args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        paper = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++)
                paper[i][j] = Integer.parseInt(st.nextToken());
        }

        answer = new int[3];
        divide(1, N, 1, N);

        for (int i : answer)
            System.out.println(i);
    }

    private static void divide(int yl, int yr, int xl, int xr) {
        if (isPaper(yl, yr, xl, xr)) {
            answer[paper[yl][xl] + 1]++;
            return;
        }

        int ym = (yr - yl + 1) / 3;
        int ym1 = yl + ym;
        int ym2 = yl + ym * 2;
        int xm = (xr - xl + 1) / 3;
        int xm1 = xl + xm;
        int xm2 = xl + xm * 2;

        divide(yl, ym1 - 1, xl, xm1 - 1);
        divide(yl, ym1 - 1, xm1, xm2 - 1);
        divide(yl, ym1 - 1, xm2, xr);
        divide(ym1, ym2 - 1, xl, xm1 - 1);
        divide(ym1, ym2 - 1, xm1, xm2 - 1);
        divide(ym1, ym2 - 1, xm2, xr);
        divide(ym2, yr, xl, xm1 - 1);
        divide(ym2, yr, xm1, xm2 - 1);
        divide(ym2, yr, xm2, xr);
    }

    private static boolean isPaper(int yl, int yr, int xl, int xr) {
        for (int y = yl; y <= yr; y++)
            for (int x = xl; x <= xr; x++)
                if (paper[y][x] != paper[yl][xl])
                    return false;

        return true;
    }
}