/*
 * Author: Minho Kim (ISKU)
 * Date: January 10, 2020
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/18245
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int d = 1; ; d++) {
            String line = br.readLine();
            if (line.equals("Was it a cat I saw?"))
                break;

            for (int i = 0; i < line.length(); i += d + 1)
                bw.write(line.charAt(i));
            bw.write('\n');
        }

        bw.close();
    }
}
