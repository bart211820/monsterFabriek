public class GrassMouse implements Monster{

    private int health;
    private int power;
    private String element = "grass";

    public GrassMouse(int health, int power) {
        this.health = health;
        this.power = power;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public String getElement() {
        return element;
    }

    @Override
    public void setHealth(int newHealth) {
        health = newHealth;
    }

    @Override
    public void showData() {
        System.out.println("A wild " + element + " Mouse appeared! Health: " + health + " Power: " + power);
    }
}
