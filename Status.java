public class Status {
    int health;
    int damage;
    int defense;

    // Builds a default status object
    // with full health, low damage and no defense
    public Status() {
        setHealth(100);
        setDamage(5);
        setDefense(0);
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }
}
