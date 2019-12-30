/*
 * Author: Minho Kim (ISKU)
 * Date: December 30, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/18116
 */

import java.io.*;
import java.util.*;

public class Main {
    
    private static int[] root, size;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        size = new int[1000001];
        root = new int[1000001];
        for (int v = 1; v <= 1000000; v++) {
            size[v] = 1;
            root[v] = v;
        }
        
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);
            
            if (cmd == 'I') {
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                
                int first = find(u);
                int second = find(v);
                if (first != second) {
                    root[second] = first;
                    size[first] += size[second];
                }
            }
            else if (cmd == 'Q') {
                int v = Integer.parseInt(st.nextToken());
                bw.write(String.valueOf(size[find(v)]));
                bw.write('\n');
            }
        }
        
        bw.close();
    }
    
    private static int find(int v) {
        if (root[v] == v)
            return v;
        return root[v] = find(root[v]);
    }
}
