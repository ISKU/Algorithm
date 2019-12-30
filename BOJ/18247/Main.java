/*
 * Author: Minho Kim (ISKU)
 * Date: December 30, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/18247
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int Y = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            
            if (Y < 12 || X < 4) {
                bw.write("-1\n");
                continue;
            }
            
            int answer = X * 11 + 4;
            bw.write(String.valueOf(answer));
            bw.write('\n');
        }
        
        bw.close();
    }
}
