import java.util.Random;

// 積み札
public class CardsStack {
    public static Card nextCard() {
        return Card.numberOf(new Random().nextInt(Card.values().length));
    }
}
