public class Speler {

    public String name;
    public int health;
    public int power;
    public String element;
    public int kills;

    public Speler(String name, int health, int power, String element) {
        this.name = name;
        this.health = health;
        this.power = power;
        this.element = element.toLowerCase();
    }

    public void addKill() {
        kills++;
    }
}
