import java.util.Scanner;
/**
 * Gère l'interaction avec l'utilisateur.
 * <p>
 * Cette classe affiche les menus, lit les saisies clavier, et fournit
 * des méthodes pour créer et gérer le perso du joueur.
 * </p>
 */
public class Menu{
    /** scanner utilisé pour lire les entrées utilisateur. */
    private final Scanner scanner;
    /**
     * initialise un nouveau menu avec un scanner pour la saisie utilisateur.
     */
    public Menu(){
        this.scanner = new Scanner(System.in);
    }
    /**
     * affiche le menu principal et lit le choix de l'utilisateur.
     *
     * @return le choix de l'utilisateur (1 = nouveau perso, 2 = démarrer, 3 = quitter)
     */
    public int displayMainMenu(){
        System.out.println("\n--- Menu Principal ---");
        System.out.println("1 - Nouveau personnage");
        System.out.println("2 - Démarrer la partie");
        System.out.println("3 - Quitter le jeu");
        System.out.print("Votre choix : ");
        return scanner.nextInt();
    }
    /**
     * crée un perso en demandant à l'utilisateur le type et le nom.
     *
     * @return un nouvel objet {@link Character} selon le choix
     */
    public Character createCharacter() {
        scanner.nextLine();
        System.out.println("\nChoisissez votre type de personnage :");
        System.out.println("1 - Warrior");
        System.out.println("   {====}");
        System.out.println("  (• •)");
        System.out.println("   \\___/");
        System.out.println("2 - Wizard");
        System.out.println("     /\\");
        System.out.println("    /__\\");
        System.out.println("   (• •)");
        System.out.println("    /___\\");
        System.out.print("Votre choix : ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Entrez le nom de votre personnage : ");
        String name = scanner.nextLine();

        return switch (choice) {
            case 1 -> new Character("Warrior", 10, 5, name);
            case 2 -> new Character("Wizard", 6, 8, name);
            default -> {
                System.out.println("Choix invalide, création d'un Warrior par défaut.");
                yield new Character("Warrior", 10, 5, name);
            }
        };
    }
    /**
     * affiche le menu de gestion du perso pour afficher ou modifier ses infos.
     *
     * @param character le perso à gérer
     */
    public void characterMenu(Character character) {
        boolean done = false;
        while (!done) {
            System.out.println("\n--- Gestion du personnage ---");
            System.out.println("1 - Afficher les infos");
            System.out.println("2 - Modifier le nom");
            System.out.println("3 - Retour au menu principal");
            System.out.print("Votre choix : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> System.out.println(character);
                case 2 -> {
                    System.out.print("Nouveau nom : ");
                    String newName = scanner.nextLine();
                    character.setName(newName);
                    System.out.println("Nom modifié !");
                }
                case 3 -> done = true;
                default -> System.out.println("Choix invalide.");
            }
        }
    }
    /**
     * affiche un message pour que le joueur appuie sur Entrée avant de lancer le dé.
     * <p>
     * cette méthode est utilisée à chaque tour pour marquer la progression du jeu.
     * </p>
     */
    public void promptDiceRoll() {
        System.out.println("\n--- Nouveau tour ---");
        System.out.println("Appuyez sur Entrée pour lancer le dé...");
        scanner.nextLine();
    }
    /**
     * demande à l'utilisateur s'il souhaite recommencer une partie.
     *
     * @return la réponse de l'utilisateur ("o" ou "n")
     */
    public String askReplay(){
        System.out.println("Veux-tu déjouer le Destin à nouveau ? (o/n) : ");
        return scanner.next();
    }
}