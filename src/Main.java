public class Main {
	public static void main(String[] args) {
		BlackJackGame con = new BlackJackGame("testName");
		con.dealer();
		con.player();
		con.judge();
		con.again();
	}
}
