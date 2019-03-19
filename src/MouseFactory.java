import java.util.concurrent.ThreadLocalRandom;

public class MouseFactory implements MonsterFactory{

    private int minMouseHealth = 10;
    private int maxMouseHealth = 50;
    private int minMousePower = 2;
    private int maxMousePower = 6;

    @Override
    public Monster createFireType() {
        return new FireMouse(createRandomHealth(), createRandomPower());
    }

    @Override
    public Monster createGrassType() {
        return new GrassMouse(createRandomHealth(), createRandomPower());
    }

    @Override
    public Monster createWaterType() {
        return new WaterMouse(createRandomHealth(), createRandomPower());
    }

    private int createRandomHealth() {
        // geeft een random nummer tussen de minimale en maximale waardes boven aangegeven
        return(ThreadLocalRandom.current().nextInt(minMouseHealth, maxMouseHealth + 1));
    }

    private int createRandomPower() {
        // geeft een random nummer tussen de minimale en maximale waardes boven aangegeven
        return(ThreadLocalRandom.current().nextInt(minMousePower, maxMousePower + 1));
    }
}
