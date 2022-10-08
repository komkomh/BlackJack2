import java.util.ArrayList;
import java.util.List;

// ディーラー
public class Dealer {
    public final String name;
    // 手札
    final List<Card> handCards = new ArrayList<>();

    public Dealer(String name) {
        this.name = name;
    }

    // カードを2枚積み札から取る
    void init() {
        handCards.add(CardsStack.nextCard()); // 1枚
        handCards.add(CardsStack.nextCard()); // 2枚
        System.out.println(name + "の初手は" + getSumNumber() + ":" + getCardViews());
    }

    // 手番(17以下なら引き続ける)
    void action() {
        while (getSumNumber() < 17) {
            final var nextCard = CardsStack.nextCard();
            System.out.println(name + "はもう一枚引きました：" + nextCard.view);
            handCards.add(nextCard);
            System.out.println(name + "のトータルは" + getSumNumber());
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
