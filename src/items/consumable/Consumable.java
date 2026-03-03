package items.consumable;

public abstract class Consumable {
    protected int healing;

    //contructeur
    public Consumable(int healing) {
        this.healing = healing;
    }

    //getters et setter
    public int getHealing() {
        return healing;
    }
    public void setHealing(int healing){
        this.healing = healing;
    }
    @Override
    public String toString() {
        return "Effet de soin : " + healing;
    }
}
