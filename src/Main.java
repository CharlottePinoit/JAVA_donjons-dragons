import game.Game;
import ui.Menu;

/**
 * Point d'entrée du jeu Donjons & Dragons en Java.
 * <p>
 * Cette classe initialise le menu et la logique du jeu, puis démarre le jeu.
 * </p>
 * <p>
 * Rôle :
 * <ul>
 *   <li>Créer une instance de {@link Menu} pour gérer l'affichage et la saisie utilisateur.</li>
 *   <li>Créer une instance de {@link Game}, en lui passant le menu pour la gestion des interactions.</li>
 *   <li>Démarrer le jeu via {@link Game#start()}.</li>
 * </ul>
 * </p>
 */
public class Main {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        Game game = new Game(menu);

        game.start();
    }
}
