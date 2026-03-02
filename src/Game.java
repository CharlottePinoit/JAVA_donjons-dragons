public class Game{
    private Character player;
    private final Menu menu;
    private final Board board;
    private final Dice dice;

    //contructeur
    public Game(Menu menu) {
        this.menu = menu;
        this.board = new Board();
        this.dice= new Dice();

    }
    //lancer le jeu
    public void start(){
        boolean running = true;
        while (running) {
            int choice = menu.displayMainMenu();
            switch (choice) {
                case 1 -> {
                    player = menu.createCharacter();
                    System.out.println("\nPersonnage créé : " + player);
                    menu.characterMenu(player);
                }
                case 2 -> {
                    System.out.println("Au revoir !");
                    running = false;
                }
                default -> System.out.println("Choix invalide.");
            }
        }
    }
    //logique plateau et déplacement
    private void playGame() {
        System.out.println("\n--- Début de la partie ---");
        player.setPosition(1);

        boolean finished= false;
        while(!finished){
            System.out.println("\nAppuyez sur Entrée pour lancer le dé...");
            new java.util.Scanner(System.in).nextLine();

            int roll = dice.roll();
            System.out.println("Vous avez fait un: " +roll);
            int newPosition = player.getPosition() + roll;
            if (newPosition > board.getSize()){
                newPosition = board.getSize();
            }
            player.setPosition(newPosition);
            System.out.println("Vous êtes sur la case " + player.getPosition() + "/" + board.getSize());

            if (player.getPosition() == board.getSize()) {
                System.out.println("\nFélicitation ! Vous avez traversé la terre du milieu sans mourir !");
                finished = true;
                System.out.println("Voulez-vous déjouer une nouvelle fois le destin? (o/n) : ");
                String answer = new java.util.Scanner(System.in).nextLine();
                if (answer.equalsIgnoreCase("o")){
                    player.setPosition(1);
                    finished = false;
                }
                else {
                    System.out.println("petit joueur...");
                }
            }
        }
    }
}
