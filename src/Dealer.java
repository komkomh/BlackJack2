// ディーラー
public class Dealer extends Gamer {

    public Dealer(String name) {
        super(name);
    }

    // 手番(17以上になるまで引き続ける)
    void action() {
        while (getSumNumber() < 17) {
            final var nextCard = CardsStack.nextCard();
            System.out.println(name + "はもう一枚引きました：" + nextCard.view);
            handCards.add(nextCard);
            System.out.println(name + "のトータルは" + getSumNumber());
        }
    }
}
