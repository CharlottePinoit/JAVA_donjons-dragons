package board.cell;

import items.consumable.BigHealthPotion;
import items.consumable.Consumable;
import items.consumable.SmallHealthPotion;
import items.offensiveEquipment.OffensiveEquipment;
import items.offensiveEquipment.spell.Fireball;
import items.offensiveEquipment.spell.LightBold;
import items.offensiveEquipment.weapon.Mace;
import items.offensiveEquipment.weapon.Sword;
import characters.Character;

import java.util.ArrayList;
import java.util.Random;
/**
 * Represents a cell containing a surprise chest.
 * <p>
 * When a character lands on this cell, a random item is generated.
 * The item can be either an offensive equipment (weapon or spell)
 * or a consumable (health potion).
 * </p>
 */
public class ItemCell extends Cell {
    /** List of possible offensive equipments that can be found */
    private ArrayList<OffensiveEquipment> possibleEquipments;
    /** List of possible consumable items that can be found */
    private ArrayList<Consumable> possibleConsumables;
    /** Random generator used to select items */
    private Random random;
    /**
     * Creates a new item cell and initializes the possible items
     * that can be found in the surprise chest.
     */
    public ItemCell() {
        this.possibleEquipments = new ArrayList<>();
        this.possibleConsumables = new ArrayList<>();
        this.random = new Random();

        // Initialisation des équipements possibles
        possibleEquipments.add(new Sword());
        possibleEquipments.add(new Mace());
        possibleEquipments.add(new Fireball());
        possibleEquipments.add(new LightBold());

        // Initialisation des consommables possibles
        possibleConsumables.add(new SmallHealthPotion());
        possibleConsumables.add(new BigHealthPotion());
    }
    /**
     * Handles the interaction when a character opens the chest.
     * A random item is selected and applied to the character.
     *
     * @param character the character landing on the cell
     */
    @Override
    public void interact(Character character) {
        // Décider aléatoirement entre un équipement ou un consommable
        boolean isEquipment = random.nextBoolean();
        System.out.println("Vous tombez sur un coffre surprise !");

        if (isEquipment && !possibleEquipments.isEmpty()) {
            // Choisir un équipement aléatoire
            OffensiveEquipment equipment = possibleEquipments.get(random.nextInt(possibleEquipments.size()));
            System.out.println("Vous trouvez : " + equipment.toString());

            // Vérifier la compatibilité et équiper si possible
            if (equipment.isCompatibleWith(character)) {
                character.equipOffensiveEquipment(equipment);
            } else {
                System.out.println("Cet équipement n'est pas compatible avec votre personnage.");
            }
        }
        else if (!possibleConsumables.isEmpty()) {
            // Choisir un consommable aléatoire
            Consumable consumable = possibleConsumables.get(random.nextInt(possibleConsumables.size()));
            System.out.println("Vous trouvez : " + consumable.toString());

            // Utiliser le consommable
            character.useConsumable(consumable);
        }
        else {
            System.out.println("Le coffre est vide...");
        }
    }
    /**
     * Returns a text representation of the item cell.
     *
     * @return a string describing the cell
     */
    @Override
    public String toString() {
        return "Case avec un coffre surprise";
    }
}

