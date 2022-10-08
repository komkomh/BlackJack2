import java.util.Random;
import java.util.Scanner;

public class BlackJackGame {
	boolean flag = true;
	private final Dealer dealer = new Dealer();
	int userSum = 0;

	private String name;

	public BlackJackGame(String str) {
		name = str;
	}

	public void player() {
		flag = true;

		userSum += CardsStack.getInitialCards();

		move(userSum, this.name, "初手");

		if (userSum > 21 || dealer.sum > 21) {
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
		dealer.execute();
	}

	public void judge() {
		if (userSum > dealer.sum && userSum <= 21 || dealer.sum > 21 && userSum <= 21) {
			System.out.println(this.name + "の勝ちです");
		} else if (dealer.sum > userSum && dealer.sum <= 21 || userSum > 21 && dealer.sum <= 21) {
			System.out.println("ディーラーの勝ちです");
		} else if (userSum > 21 && dealer.sum > 21 || userSum == dealer.sum) {
			System.out.println("ドロー");
		}
	}

	public void move(int i, String str1, String str2) {
		System.out.println(str1 + "の" + str2 + "は" + i);
		if (i > 21) {
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
				dealer.sum = 0;
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
