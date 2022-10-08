
// ディーラー
public class Dealer {
    public int sum;

    void execute() {
        sum += CardsStack.getInitialCards();
        System.out.println("ディーラーの初手は" + sum);
        while (sum < 17) {
            System.out.println("ディーラーはもう一枚引きました");
            int nextCard = CardsStack.getCard();
            new CardViewer(nextCard);
            sum += nextCard;
            System.out.println("ディーラーのトータルは" + sum);
        }
    }
}
