/*
 * Author: Minho Kim (ISKU)
 * Date: March 17, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/12791
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int Q = sc.nextInt();
		
		HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>() {{
			put(1967, new ArrayList<String>() {{add("DavidBowie");}});
			put(1969, new ArrayList<String>() {{add("SpaceOddity");}});
			put(1970, new ArrayList<String>() {{add("TheManWhoSoldTheWorld");}});
			put(1971, new ArrayList<String>() {{add("HunkyDory");}});
			put(1972, new ArrayList<String>() {{add("TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars");}});
			put(1973, new ArrayList<String>() {{add("AladdinSane"); add("PinUps");}});
			put(1974, new ArrayList<String>() {{add("DiamondDogs");}});
			put(1975, new ArrayList<String>() {{add("YoungAmericans");}});
			put(1976, new ArrayList<String>() {{add("StationToStation");}});
			put(1977, new ArrayList<String>() {{add("Low"); add("Heroes");}});
			put(1979, new ArrayList<String>() {{add("Lodger");}});
			put(1980, new ArrayList<String>() {{add("ScaryMonstersAndSuperCreeps");}});
			put(1983, new ArrayList<String>() {{add("LetsDance");}});
			put(1984, new ArrayList<String>() {{add("Tonight");}});
			put(1987, new ArrayList<String>() {{add("NeverLetMeDown");}});
			put(1993, new ArrayList<String>() {{add("BlackTieWhiteNoise");}});
			put(1995, new ArrayList<String>() {{add("1.Outside");}});
			put(1997, new ArrayList<String>() {{add("Earthling");}});
			put(1999, new ArrayList<String>() {{add("Hours");}});
			put(2002, new ArrayList<String>() {{add("Heathen");}});
			put(2003, new ArrayList<String>() {{add("Reality");}});
			put(2013, new ArrayList<String>() {{add("TheNextDay");}});
			put(2016, new ArrayList<String>() {{add("BlackStar");}});
		}};
		
		while (Q-- > 0) {
			int S = sc.nextInt();
			int E = sc.nextInt();
			
			ArrayList<String> answer = new ArrayList<>();
			for (int i = S; i <= E; i++)
				if (map.containsKey(i))
					for (String s : map.get(i))
						answer.add(String.format("%d %s", i, s));
			
			System.out.println(answer.size());
			for (String s : answer)
				System.out.println(s);
		}
	}
}