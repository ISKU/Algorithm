/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.23
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10931
 */

import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
	public static void main(String... args) throws NoSuchAlgorithmException {
		MessageDigest sh = MessageDigest.getInstance("SHA-384");
		sh.update(new Scanner(System.in).next().getBytes());
		StringBuffer output = new StringBuffer();

		for (byte b : sh.digest())
			output.append(Integer.toHexString(0xf & b >> 4) + Integer.toHexString(0xf & b));

		System.out.println(output);
	}
}