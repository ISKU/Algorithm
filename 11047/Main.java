/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.31
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11047
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int[] kindOfCoin = new int[input.nextInt()];
		int valueOfCoins = input.nextInt();
		int numberOfCoins = 0;

		for (int coin = 0; coin < kindOfCoin.length; coin++)
			kindOfCoin[coin] = input.nextInt();

		for (int currentCoin = kindOfCoin.length - 1; currentCoin >= 0; currentCoin--) {
			if (valueOfCoins >= kindOfCoin[currentCoin]) {
				numberOfCoins += valueOfCoins / kindOfCoin[currentCoin]; // number of coins
				valueOfCoins = valueOfCoins % kindOfCoin[currentCoin]; // remainder
			}
			if (valueOfCoins <= 0) // end
				break;
		}

		System.out.println(numberOfCoins);
	}
}