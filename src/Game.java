public class Game{
    private Character player;
    private final Menu menu;

    //contructeur
    public Game(Menu menu) {
        this.menu = menu;
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
}
