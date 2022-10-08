import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

    public final String name;
    // 手札
    final List<Card> handCards = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    // カードを2枚積み札から取る
    void init() {
        handCards.add(CardsStack.nextCard()); // 1枚
        handCards.add(CardsStack.nextCard()); // 2枚
        System.out.println(name + "の初手は" + getSumNumber() + ":" + getCardViews());
    }

    public void action() {

        while (true) {
            System.out.println("もう一度引きますか？「はい」or「いいえ」");
            String jud = new Scanner(System.in).next();

            if (jud.equals("はい")) {
                final var nextCard = CardsStack.nextCard();
                System.out.println(name + "はもう一枚引きました：" + nextCard.view);
                handCards.add(nextCard);
                System.out.println(name + "のトータルは" + getSumNumber());
                if (getSumNumber() > 21) {
                    return;
                }
            } else if (jud.equals("いいえ")) {
                return;
            } else {
                System.out.println("「はい」か「いいえ」で回答してください");
            }
        }
    }

    final Integer getSumNumber() {
        return handCards
                .stream()
                .mapToInt(card -> card.number)
                .sum();
    }

    final String getCardViews() {
        return handCards
                .stream()
                .map(card -> card.view)
                .reduce("", (l, r) -> l + "," + r);
    }

    boolean isBust() {
        return getSumNumber() > 21;
    }
}
