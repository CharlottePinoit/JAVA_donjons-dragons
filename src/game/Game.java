package game;

import board.Board;
import board.Dice;
import characters.Character;
import exceptions.OutOfBoardException;
import ui.Menu;

/**
 * Gère la logique principale du jeu.
 * <p>
 * La classe game.Game coordonne le déroulement du jeu : gestion du plateau,
 * des déplacements du perso, des tours de jeu et de la boucle principale
 * via le menu. Elle utilise les classes {@link Menu}, {@link Board}, {@link Dice}
 * et {@link Character}.
 * </p>
 */
public class Game{
    /** Le perso joué par l'utilisateur. */
    private characters.Character player;
    /** ui.Menu pour interagir avec l'utilisateur. */
    private final Menu menu;
    /** Plateau de jeu. */
    private final Board board;
    /** Dé virtuel pour les déplacements du perso. */
    private final Dice dice;

    //contructeur
    /**
     * Initialise le jeu avec le menu fourni.
     * <p>
     * Le plateau et le dé sont créés automatiquement à la création de l'objet game.Game.
     * </p>
     * @param menu le menu pour gérer les interactions utilisateur
     */
    public Game(Menu menu) {
        this.menu = menu;
        this.board = new Board();
        this.dice= new Dice();

    }
    //lancer le jeu
    /**
     * Démarre la boucle principale du jeu.
     * <p>
     * Affiche le menu principal en continu et gère les choix de l'utilisateur :
     * créer un perso, démarrer une partie ou quitter le jeu.
     * </p>
     */
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
                    if (player == null) {
                        System.out.println("Vous devez d'abord créer un personnage !");
                    }
                    else {
                        playGame();
                    }
                }
                case 3 -> {
                    System.out.println("Au revoir !");
                    running = false;
                }
                default -> System.out.println("Choix invalide.");
            }
        }
    }
    //logique plateau et déplacement
    /**
     * Gère la logique du plateau et le déplacement du perso.
     * <p>
     * Le personnage commence à la position 1 et avance sur le plateau en lançant
     * le dé à chaque tour. La position maximale est celle du plateau.
     * À la fin du plateau, le joueur peut choisir de recommencer la partie.
     * </p>
     */
    private void playGame() {
        System.out.println("\n--- Début de la partie ---");
        player.setPosition(1);

        boolean finished= false;
        while(!finished){
            menu.promptDiceRoll();

            int roll = dice.roll();
            System.out.println("Vous avez fait un: " +roll);
            int newPosition = player.getPosition() + roll;

            try {
                board.checkPosition(newPosition);
                player.setPosition(newPosition);

            } catch (OutOfBoardException e) {
                System.out.println(e.getMessage());
                player.setPosition(board.getSize());
            }
            player.setPosition(newPosition);
            System.out.println("Vous êtes sur la case " + player.getPosition() + "/" + board.getSize());

            if (player.getPosition() == board.getSize()) {
                System.out.println("\nFélicitation ! Vous avez traversé la terre du milieu sans mourir !");
                finished = true;
                String answer = menu.askReplay();

                if (answer.equalsIgnoreCase("o")) {
                    player.setPosition(1);
                    finished = false;
                } else {
                    System.out.println("Petit joueur...");
                }
            }
        }
    }
}
