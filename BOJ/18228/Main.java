/*
 * Author: Minho Kim (ISKU)
 * Date: December 30, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/18228
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int ice = Integer.parseInt(st.nextToken());            
            if (ice == -1) {
                answer = min;
                min = Integer.MAX_VALUE;
                continue;
            }
            
            min = Math.min(min, ice);
        }
        answer += min;
        
        System.out.println(answer);
    }
}
