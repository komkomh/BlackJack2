import java.util.Random;
import java.util.Scanner;

public class BlackJackGame {
	boolean flag = true;
	private final Dealer dealer;
	private final Player player;

	public BlackJackGame(String name) {
		dealer = new Dealer();
		player = new Player(name);
	}

	public void player() {
		player.execute();
	}

	public void dealer() {
		dealer.execute();
	}

	public void judge() {
		if (player.sum > dealer.sum && player.sum <= 21 || dealer.sum > 21 && player.sum <= 21) {
			System.out.println(player.name + "の勝ちです");
		} else if (dealer.sum > player.sum && dealer.sum <= 21 || player.sum > 21 && dealer.sum <= 21) {
			System.out.println("ディーラーの勝ちです");
		} else if (player.sum > 21 && dealer.sum > 21 || player.sum == dealer.sum) {
			System.out.println("ドロー");
		}
	}

	public void again() {
		boolean isAgain = true;

		while (isAgain) {
			System.out.println("もう一度しますか？「はい」or「いいえ」");
			String yn = new Scanner(System.in).next();
			if (yn.equals("はい")) {
				dealer.sum = 0;
				player.sum = 0;
				dealer();
				player();
				judge();
			} else if (yn.equals("いいえ")) {
				isAgain = false;
				System.out.println("終了しました");
			} else {
				System.out.println("「はい」か「いいえ」で回答してください");
			}
		}
	}
}
