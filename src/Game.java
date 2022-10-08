import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        // ゲームループ
        while (true) {
            // ディーラーを生成する
            final var dealer = new Dealer("ディーラー");
            // プレイヤーを生成する
            final var player = new Player("プレイヤー");
            // ディーラーは初期カードとして積み札からカードを2枚取得する
            dealer.init();
            // プレイヤーは初期カードとして積み札からカードを2枚取得する
            player.init();
            // フレイヤーの手番を実行する
            player.action();
            // ディーラーの手番を実行する
            dealer.action();
            // 勝敗を判定する
            judge(dealer, player);
            System.out.println("もう一度しますか？「はい」or「いいえ」");
            if (question()) {
                continue;
            }
            break;
        }
        System.out.println("終了しました");
    }

    // 再ゲームするかプレイヤーに確認する
    private static boolean question() {
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
        if (player.isBust()) {
            System.out.println(dealer.name + "の勝ちです");
            return;
        }
        if (dealer.isBust()) {
            System.out.println(player.name + "の勝ちです");
            return;
        }
        if (dealer.getSumNumber() > player.getSumNumber()) {
            System.out.println(player.name + "の勝ちです");
            return;
        }
        if (player.getSumNumber() > dealer.getSumNumber()) {
            System.out.println(player.name + "の勝ちです");
            return;
        }
        System.out.println("ドロー");
    }
}
