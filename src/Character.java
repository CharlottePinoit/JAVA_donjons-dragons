public class Character{
    //attributs privés
    private String type;
    private int life;
    private int attack;
    private String name;


    //constructeur
    public Character(String type, int life, int attack, String name){
        this.type = type;
        this.life = life;
        this.attack = attack;
        this.name = name;
    }
    //getters & setters
    public String getType() {
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
    public int getAttack(){
        return attack;
    }
    public void setAttack(int attack){
        this.attack = attack;
    }
    public int getLife(){
        return life;
    }
    public void setLife(int life){
        this.life = life;
    }
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    //méthode pour fin du jeu
    public boolean isAlive(){
        return life > 0;
    }
    //pour redéfinir le toString comme on veut
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