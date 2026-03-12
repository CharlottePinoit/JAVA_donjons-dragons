package board;
import exceptions.OutOfBoardException;
import board.cell.Cell;
import board.cell.EmptyCell;
import board.cell.EnemyCell;
import board.cell.ItemCell;
import enemies.Dragon;
import enemies.Goblin;
import enemies.Sorcerer;
import items.consumable.BigHealthPotion;
import items.consumable.SmallHealthPotion;
import items.offensiveEquipment.weapon.Mace;
import items.offensiveEquipment.weapon.Sword;
import items.offensiveEquipment.spell.LightBold;
import items.offensiveEquipment.spell.Fireball;
import java.util.HashMap;
import java.util.Map;
/**
 * Represents the game board.
 * <p>
 * The board contains a fixed number of squares and is used
 * to track the character's progression during the game.
 * </p>
 */
public class Board {

    /** Total number of squares on the board */
    private final int size = 64;

    /** List of cells on the board */
    private final Map<Integer, Cell> cells;

    /**
     * Creates a new board with 64 cells.
     * The cells are randomly initialized with enemies, items, or empty cells.
     */
    public Board() {
        this.cells = new HashMap<>();

        // --- ENNEMIS ---
        // Gobelins
        int[] goblins = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30};
        for (int pos : goblins) {
            cells.put(pos, new EnemyCell(new Goblin()));
        }
        // Sorciers
        int[] sorcerers = {10, 20, 25, 32, 35, 36, 37, 40, 44, 47};
        for (int pos : sorcerers) {
            cells.put(pos, new EnemyCell(new Sorcerer()));
        }
        // Dragons
        int[] dragons = {45, 52, 56, 62};
        for (int pos : dragons) {
            cells.put(pos, new EnemyCell(new Dragon()));
        }

        // --- ITEMS ---
        // Massues
        int[] maces = {2, 5, 11, 22, 38};
        for (int pos : maces) {
            cells.put(pos, new ItemCell(new Mace()));
        }
        // Epées
        int[] swords = {19, 26, 42, 53};
        for (int pos : swords) {
            cells.put(pos, new ItemCell(new Sword()));
        }
        // Sorts éclair
        int[] lightBolts = {1, 4, 8, 17, 23};
        for (int pos : lightBolts) {
            cells.put(pos, new ItemCell(new LightBold()));
        }
        // Boules de feu
        int[] fireballs = {48, 49};
        for (int pos : fireballs) {
            cells.put(pos, new ItemCell(new Fireball()));
        }
        // Potions standards
        int[] smallPotions = {7, 13, 31, 33, 39, 43};
        for (int pos : smallPotions) {
            cells.put(pos, new ItemCell(new SmallHealthPotion()));
        }
        // Grandes potions
        int[] bigPotions = {28, 41};
        for (int pos : bigPotions) {
            cells.put(pos, new ItemCell(new BigHealthPotion()));
        }

        // Toutes les cases non définies sont vides
        for (int i = 1; i <= size; i++) {
            cells.putIfAbsent(i, new EmptyCell());
        }
    }

    /**
     * Returns the total number of squares on the board.
     *
     * @return the number of squares (64)
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the cell at the specified position.
     *
     * @param position the position on the board (1-based index)
     * @return the cell at the specified position
     */
    public Cell getCell(int position) {
        return cells.get(position);
    }

    /**
     * Checks if a position is within the board limits.
     *
     * @param position the position to check
     * @throws OutOfBoardException if the position exceeds the board size
     */
    public void checkPosition(int position) throws OutOfBoardException {
        if (position > size) {
            throw new OutOfBoardException(
                    "Position " + position + " exceeds the board size (" + size + ")"
            );
        }
    }
}