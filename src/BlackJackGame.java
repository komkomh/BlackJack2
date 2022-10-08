import java.util.Random;
import java.util.Scanner;

public class BlackJackGame {
	boolean flag = true;
	int dealerSum = 0;
	int userSum = 0;

	private String name;

	public BlackJackGame(String str) {
		name = str;
	}

	public void player() {
		flag = true;

		userSum += CardsStack.getInitialCards();

		move(userSum, this.name, "初手");

		if (userSum > 21 || dealerSum > 21) {
			judge();
			flag = false;
		}

		while (flag) {
			System.out.println("もう一度引きますか？「はい」or「いいえ」");
			String jud = new Scanner(System.in).next();

			if (jud.equals("はい")) {
				int ageinmas = new Random().nextInt(13) + 1;
				new CardViewer(ageinmas);
				userSum += ageinmas;
				move(userSum, this.name, "トータル");
				if (userSum > 21) {
					judge();
				}
			} else if (jud.equals("いいえ")) {
				judge();
				flag = false;
			} else {
				System.out.println("「はい」か「いいえ」で回答してください");
			}
		}
	}

	public void dealer() {
		dealerSum += CardsStack.getInitialCards();
		move(dealerSum, "ディーラー", "初手");
		while (dealerSum < 17) {
			System.out.println("ディーラーはもう一枚引きました");
			int agein = new Random().nextInt(13) + 1;
			new CardViewer(agein);
			dealerSum += agein;
			move(dealerSum, "ディーラー", "トータル");
		}
	}

	public void judge() {
		if (userSum > dealerSum && userSum <= 21 || dealerSum > 21 && userSum <= 21) {
			System.out.println(this.name + "の勝ちです");
		} else if (dealerSum > userSum && dealerSum <= 21 || userSum > 21 && dealerSum <= 21) {
			System.out.println("ディーラーの勝ちです");
		} else if (userSum > 21 && dealerSum > 21 || userSum == dealerSum) {
			System.out.println("ドロー");
		}
	}

	public void move(int i, String str1, String str2) {
		System.out.println(str1 + "の" + str2 + "は" + i);
		if (!(i <= 21)) {
			flag = false;
			System.out.println(str1 + "はオーバーです");
		}
	}

	public void again() {
		boolean isAgain = true;

		while (isAgain) {
			System.out.println("もう一度しますか？「はい」or「いいえ」");
			String yn = new Scanner(System.in).next();
			if (yn.equals("はい")) {
				dealerSum = 0;
				userSum = 0;
				dealer();
				player();
			} else if (yn.equals("いいえ")) {
				isAgain = false;
				System.out.println("終了しました");
			} else {
				System.out.println("「はい」か「いいえ」で回答してください");
			}
		}
	}

}
