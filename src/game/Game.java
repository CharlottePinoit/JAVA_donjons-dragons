package game;

import board.Board;
import board.Dice;
import characters.Character;
import exceptions.OutOfBoardException;
import ui.Menu;

/**
 * Manages the main game logic.
 * <p>
 * The {@link Game} class coordinates the flow of the game: board management,
 * character movement, turn handling, and the main loop via the {@link Menu}.
 * It uses the {@link Board}, {@link Dice}, and {@link Character} classes.
 * </p>
 */
public class Game {

    /** The character played by the user */
    private Character player;

    /** Menu for interacting with the user */
    private final Menu menu;

    /** Game board */
    private final Board board;

    /** Virtual dice used for character movement */
    private final Dice dice;

    //constructeur
    /**
     * Initializes the game with the provided menu.
     * <p>
     * The board and dice are automatically created when the {@link Game} object is instantiated.
     * </p>
     *
     * @param menu the menu used to manage user interactions
     */
    public Game(Menu menu) {
        this.menu = menu;
        this.board = new Board();
        this.dice= new Dice();

    }
    //lancer le jeu
    /**
     * Starts the main game loop.
     * <p>
     * Continuously displays the main menu and handles user choices:
     * create a character, start a game, or exit.
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
     * Handles board logic and character movement.
     * <p>
     * The character starts at position 1 and moves forward on the board
     * by rolling the dice each turn. The maximum position is the board's size.
     * When reaching the end of the board, the player can choose to restart the game.
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
