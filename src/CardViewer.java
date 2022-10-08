
public class CardViewer {

	public CardViewer(int code) {
		String str = null;
		switch(code) {
		case 1:
			str = "A";
			break;
		case 11:
			str = "J";
			break;
		case 12:
			str = "Q";
			break;
		case 13:
			str = "K";
			break;
		default:
			str = String.valueOf(code);
		}
		System.out.println(str);
	}
}
