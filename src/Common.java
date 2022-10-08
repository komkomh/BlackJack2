import java.util.Scanner;

// 共通クラス
public class Common {
    // 再ゲームするかプレイヤーに確認する
    public static boolean question(String question) {
        System.out.println(question);
        while (true) {
            String yn = new Scanner(System.in).next();
            if (yn.equals("はい")) {
                return true;
            } else if (yn.equals("いいえ")) {
                return false;
            } else {
                System.out.println("「はい」か「いいえ」で回答してください");
            }
        }
    }
}
