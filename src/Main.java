public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Game game = new Game(menu);

        game.start();
    }
}
