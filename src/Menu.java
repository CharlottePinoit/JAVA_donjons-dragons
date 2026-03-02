import java.util.Scanner;

public class Menu{
    private final Scanner scanner;

    public Menu(){
        this.scanner = new Scanner(System.in);
    }
    public int displayMainMenu(){
        System.out.println("\n--- Menu Principal ---");
        System.out.println("1 - Nouveau personnage");
        System.out.println("2 - Quitter le jeu");
        System.out.print("Votre choix : ");
        return scanner.nextInt();
    }

    public Character createCharacter() {
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
}