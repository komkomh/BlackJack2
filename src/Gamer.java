import java.util.ArrayList;
import java.util.List;

public abstract class Gamer {
    // 名前
    final String name;
    // 手札
    final List<Card> handCards = new ArrayList<>();

    public Gamer(String name) {
        this.name = name;
    }

    // カードを2枚積み札から取る
    void init() {
        handCards.add(CardsStack.nextCard()); // 1枚
        handCards.add(CardsStack.nextCard()); // 2枚
        System.out.println(name + "の初手は" + getSumNumber() + ":" + getCardViews());
    }

    abstract void action();

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
