package game;

import board.Board;
import board.Dice;
import characters.Character;
import db.DatabaseManager;
import exceptions.OutOfBoardException;
import ui.Menu;
import board.cell.Cell;
import board.cell.EmptyCell;
import board.cell.EnemyCell;
import board.cell.ItemCell;
import characters.Character;
import enemies.Dragon;
import enemies.Goblin;
import enemies.Sorcerer;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Manages the main game logic for the Dungeons & Dragons-inspired board game.
 * <p>
 * The {@link Game} class coordinates the flow of the game: it handles the game board,
 * character movement, turn handling, and interactions via the {@link Menu}.
 * It uses the {@link Board} to represent the game map, {@link Dice} for movement rolls,
 * and {@link Character} to represent the player.
 * </p>
 * <p>
 * Responsibilities include:
 * <ul>
 *     <li>Starting and managing the main game loop</li>
 *     <li>Handling player choices via the menu</li>
 *     <li>Moving the character and resolving interactions on each board cell</li>
 *     <li>Checking for game-over and victory conditions</li>
 * </ul>
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
                    DatabaseManager.createHero(player);
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
     * Handles the gameplay logic and character movement on the board.
     * <p>
     * Each turn, the player rolls the dice to determine the number of cells
     * to move forward. When the player lands on a cell, the corresponding
     * interaction occurs (empty, enemy, or item). The game ends when the
     * player reaches the end of the board or loses all life points.
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

            // Interaction avec la case actuelle
            Cell currentCell = board.getCell(player.getPosition());
            //System.out.println("Vous tombez sur : " + currentCell.toString());
            currentCell.interact(player);

            // Enregistrer l'état du personnage après chaque tour
            DatabaseManager.editHero(player);

            // Vérification de la fin de partie
            if (!player.isAlive()) {
                System.out.println("\nGame Over ! Vous avez perdu tous vos points de vie.");
                finished = true;
            } else if (player.getPosition() == board.getSize()) {
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
