/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.02
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14406
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		System.out.println(answer());
	}

	private static String answer() {
		switch (new Scanner(System.in).nextLine()) {
		case "걸.걸.걸":
			return "더 사랑할걸, 더 참을걸, 더 즐길걸.";
		case "사.우.나":
			return "사랑과 우정을 나누자";
		case "지.화.자":
			return "지금부터 화합하자";
		case "재.건.축":
			return "재미있고 건강하게, 축복하며 살자";
		case "오.징.어":
			return "오래도록 징그럽게 어울리자";
		case "해.당.화":
			return "해가 갈수록 당당하고 화려하게";
		case "우.아.미":
			return "우아하고 아름다운 미래를 위하여";
		case "재.개.발":
			return "재미있고 개성있게 발전적으로 살자";
		case "사.이.다":
			return "사랑하자 이 세상 다 바쳐";
		case "주.전.자":
			return "주인의식을 갖고 전문성을 갖추고 자신있게 살자";
		case "나.가.자":
			return "나라, 가정, 자신의 발전을 위하여";
		case "이.기.자":
			return "이런 기회를 자주 만들자";
		case "청.바.지":
			return "청춘은 바로 지금부터";
		default:
			return "";
		}
	}
}