package board.cell;


import items.consumable.Consumable;

import items.offensiveEquipment.OffensiveEquipment;

import characters.Character;

/**
 * Represents a cell containing a surprise chest.
 * <p>
 * When a character lands on this cell, a random item is generated.
 * The item can be either an offensive equipment (weapon or spell)
 * or a consumable (health potion).
 * </p>
 */
public class ItemCell extends Cell {

        private final Object item; // OffensiveEquipment ou Consumable

        public ItemCell(Object item) {
            this.item = item;
        }
    /**
     * Handles the interaction when a character opens the chest.
     * A random item is selected and applied to the character.
     *
     * @param character the character landing on the cell
     */
    @Override
    public void interact(Character character) {
        System.out.println(
                        "  ____  \n" +
                        " /____\\ \n" +
                        "| [__] |\n" +
                        "|______|\n" +
                        "Vous trouvez un coffre surprise !"
        );

        if (item instanceof OffensiveEquipment equipment) {
            System.out.println(equipment.getAsciiArt());
            character.equipOffensiveEquipment(equipment);
        } else if (item instanceof Consumable consumable) {
            System.out.println(consumable.getAsciiArt());
            character.useConsumable(consumable);
        }
    }
    /**
     * Returns a text representation of the item cell.
     *
     * @return a string describing the cell
     */
    @Override
    public String toString() {
        return "Case avec un coffre : " + item.toString();
    }
}

