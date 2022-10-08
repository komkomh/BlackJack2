import java.util.Random;

// 積み札
public class CardsStack {
    public static int getCard() {
        return new Random().nextInt(13) + 1;
    }

    // 初期カードを2枚引く
    public static int getInitialCards() {
        int firstCard = CardsStack.getCard();
        new CardViewer(firstCard);
        int secondCard = CardsStack.getCard();
        new CardViewer(secondCard);
        return firstCard + secondCard;
    }
}
