/**
 * Représente un personnage jouable.
 * <p>
 * Chaque perso a un type (Guerrier ou Magicien), un nom, des points de vie,
 * une valeur d'attaque et une position sur le plateau.
 * La position est utilisée pour suivre l'avancement du perso dans le jeu.
 * </p>
 */
public class Character{
    //attributs privés
    private String type;  /** type du perso (warrior ou wizard) */
    private int life; /** points de vie actuels du perso */
    private int attack; /** valeur d'attaque du perso */
    private String name; /** nom du perso */
    private int position; /** position actuelle du perso sur le plateau */

    /** constructeur
     * Crée un nouveau perso avec les caractéristiques spécifiées.
     *
     * @param type   le type du perso
     * @param life   les points de vie de base
     * @param attack la valeur d'attaque du perso
     * @param name   le nom du perso
     */
    public Character(String type, int life, int attack, String name){
        this.type = type;
        this.life = life;
        this.attack = attack;
        this.name = name;
    }
    //getters & setters

    /**
     * Retourne le type du perso.
     *
     * @return le type du perso
     */
    public String getType() {return type; }
    /**
     * Définit le type du perso.
     *
     * @param type le nouveau type du perso
     */
    public void setType(String type){
        this.type = type;
    }
    /**
     * Retourne les points de vie du perso.
     *
     * @return les points de vie actuels
     */
    public int getLife(){
        return life;
    }
    /**
     * Modifie les points de vie du perso.
     *
     * @param life les nouveaux points de vie
     */
    public void setLife(int life){this.life = life;}
    /**
     * Retourne la valeur d'attaque du perso.
     *
     * @return la valeur d'attaque
     */
    public int getAttack(){
        return attack;
    }
    /**
     * Modifie la valeur d'attaque du perso.
     *
     * @param attack la nouvelle valeur d'attaque
     */
    public void setAttack(int attack){
        this.attack = attack;
    }
    /**
     * Retourne le nom du perso.
     *
     * @return le nom
     */
    public String getName() {
        return name;
    }
    /**
     * Modifie le nom du perso.
     *
     * @param name le nouveau nom
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Retourne la position actuelle du perso sur le plateau.
     *
     * @return la position (case actuelle)
     */
    public int getPosition(){
        return position;
    }
    /**
     * Modifie la position actuelle du perso sur le plateau.
     *
     * @param position la nouvelle position
     */
    public void setPosition(int position) {
        this.position = position;
    }


    //méthode pour fin du jeu
    /**
     * Vérifie si le perso est toujours en vie.
     *
     * @return {@code true} si les points de vie > 0, sinon {@code false}
     */
    public boolean isAlive(){
        return life > 0;
    }

    //pour redéfinir le toString comme on veut
    /**
     * Retourne une représentation textuelle du perso.
     *
     * @return chaîne contenant le nom, le type, les points de vie et l'attaque
     */
    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", attack=" + attack +
                ", life=" + life +
                '}';
    }






}