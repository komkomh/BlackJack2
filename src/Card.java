import java.util.Random;

public enum Card {
    CARD1(1, "A"),
    CARD2(2, "2"),
    CARD3(3, "3"),
    CARD4(4, "4"),
    CARD5(5, "5"),
    CARD6(6, "6"),
    CARD7(7, "7"),
    CARD8(8, "8"),
    CARD9(9, "9"),
    CARD10(10, "10"),
    CARD11(10, "J"),
    CARD12(10, "Q"),
    CARD13(10, "K");

    final Integer number;
    final String view;
    Card(Integer number, String view) {
        this.number = number;
        this.view = view;
    }

    static Card numberOf(Integer number) {
        return values()[number];
    }
}
