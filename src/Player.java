import java.util.Scanner;

public class Player {

    public final String name;
    public int sum;

    public Player(String name) {
        this.name = name;
    }

    public void execute() {
        sum += CardsStack.getInitialCards();
        System.out.println("プレイヤーの初手は" + sum);

        while (true) {
            System.out.println("もう一度引きますか？「はい」or「いいえ」");
            String jud = new Scanner(System.in).next();

            if (jud.equals("はい")) {
                int nextCard = CardsStack.getCard();
                new CardViewer(nextCard);
                sum += nextCard;
                System.out.println(name + "のトータルは" + sum);
                if (sum > 21) {
                    return;
                }
            } else if (jud.equals("いいえ")) {
                return;
            } else {
                System.out.println("「はい」か「いいえ」で回答してください");
            }
        }
    }
}
