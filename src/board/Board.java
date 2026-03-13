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

import java.util.ArrayList;
import java.util.Collections;
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

        //Crée une liste avec toutes les cellules dans l'ordre
        ArrayList<Cell> cellList = new ArrayList<>();

        //Ajoute les ennemies
        for (int i = 0; i < 4;  i++) cellList.add(new EnemyCell(new Dragon()));
        for (int i = 0; i < 10; i++) cellList.add(new EnemyCell(new Sorcerer()));
        for (int i = 0; i < 10; i++) cellList.add(new EnemyCell(new Goblin()));

        //Ajoute les items
        for (int i = 0; i < 5; i++) cellList.add(new ItemCell(new Mace()));
        for (int i = 0; i < 4; i++) cellList.add(new ItemCell(new Sword()));
        for (int i = 0; i < 5; i++) cellList.add(new ItemCell(new LightBold()));
        for (int i = 0; i < 2; i++) cellList.add(new ItemCell(new Fireball()));
        for (int i = 0; i < 6; i++) cellList.add(new ItemCell(new SmallHealthPotion()));
        for (int i = 0; i < 2; i++) cellList.add(new ItemCell(new BigHealthPotion()));

        //Ajoute les cases vides
        for (int i = 0; i < 16; i++) cellList.add(new EmptyCell());

        //mélange aléatoirement
        Collections.shuffle(cellList);

        //Boucle pour mettre chaque cellule dans la Map avec sa position
        for (int i = 0; i < size; i++) {
            cells.put(i + 1, cellList.get(i));
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