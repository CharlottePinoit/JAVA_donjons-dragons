package board;

import java.util.Random;
/**
 * Représente un dé virtuel à N faces.
 * <p>
 * Dans cette version, le dé possède un nombre fixe de faces (6) et peut être lancé
 * pour générer un nombre aléatoire compris entre 1 et 6 inclus.
 * </p>
 */
public class Dice {

    /** nombre de faces du dé. */
    private final int sides = 6;

    /** générateur de nombres aléatoires pour simuler le lancer de dé. */
    private final Random random;

    /**
     * crée un dé virtuel avec un générateur de nombres aléatoires.
     * la face maximale est définie par l'attribut {@link #sides}.
     */
    public Dice() {
        random = new Random();
    }

    /**
     * lance le dé et retourne un résultat aléatoire entre 1 et le nombre de faces inclus.
     *
     * @return le résultat du lancer (entre 1 et 6)
     */
    public int roll() {
        return random.nextInt(sides) +1;
    }
}
