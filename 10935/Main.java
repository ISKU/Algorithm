/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.11.24
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10935
 */

import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.Base64;

public class Main {
	public static void main(String args[]) throws UnsupportedEncodingException {
		System.out.print(new String(Base64.getEncoder().encode(new Scanner(System.in).next().getBytes("UTF-8"))));
	}
}