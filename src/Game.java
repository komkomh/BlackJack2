import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        // ゲームループ
        while (true) {
            // ディーラーを生成する
            final var dealer = new Dealer();
            // プレイヤーを生成する
            final var player = new Player("testName");
            // ディーラーの手番を実行する
            dealer.execute();
            // フレイヤーの手番を実行する
            player.execute();
            // 勝敗を判定する
            judge(dealer, player);
            System.out.println("もう一度しますか？「はい」or「いいえ」");
            if (isAgain()) {
                continue;
            }
            break;
        }
        System.out.println("終了しました");
    }

    // 再ゲームするかプレイヤーに確認する
    private static boolean isAgain() {
        while (true) {
            String yn = new Scanner(System.in).next();
            if (yn.equals("はい")) {
                return true;
            } else if (yn.equals("いいえ")) {
                return false;
            } else {
                System.out.println("「はい」か「いいえ」で回答してください");
            }
        }
    }

    public static void judge(Dealer dealer, Player player) {
        if (player.sum > dealer.sum && player.sum <= 21 || dealer.sum > 21 && player.sum <= 21) {
            System.out.println(player.name + "の勝ちです");
        } else if (dealer.sum > player.sum && dealer.sum <= 21 || player.sum > 21 && dealer.sum <= 21) {
            System.out.println("ディーラーの勝ちです");
        } else if (player.sum > 21 && dealer.sum > 21 || player.sum == dealer.sum) {
            System.out.println("ドロー");
        }
    }
}
