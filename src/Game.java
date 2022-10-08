import java.util.Optional;

// ゲーム
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
            getWinner(dealer, player).ifPresentOrElse(
                    winner -> System.out.println(winner.name + "の勝ちです"),
                    () -> System.out.println("ドロー"));
            // 再ゲームを問い合わせる
            if (Common.question("もう一度しますか？「はい」or「いいえ」")) {
                System.out.println("-----------------------");
                continue;
            }
            break;
        }
        System.out.println("終了しました");
    }

    // 勝者を取得する
    public static Optional<Gamer> getWinner(Dealer dealer, Player player) {
        // プレイヤーがバーストしてれば
        if (player.isBust()) {
            // 勝者はディーラー
            return Optional.of(dealer);
        }
        // ディーラーがバーストしてれば
        if (dealer.isBust()) {
            // 勝者はプレイヤー
            return Optional.of(player);
        }
        // ディーラーが21に近ければ
        if (dealer.getSumNumber() > player.getSumNumber()) {
            // 勝者はディーラー
            return Optional.of(dealer);
        }
        // プレイヤーが21に近ければ
        if (dealer.getSumNumber() < player.getSumNumber()) {
            // 勝者はプレイヤー
            return Optional.of(player);
        }
        // いずれでもなければ勝者はなし
        return Optional.empty();
    }
}
