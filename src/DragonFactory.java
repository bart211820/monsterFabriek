import java.util.concurrent.ThreadLocalRandom;

public class DragonFactory implements MonsterFactory {

    private int minDragonHealth = 200;
    private int maxDragonHealth = 400;
    private int minDragonPower = 50;
    private int maxDragonPower = 100;

    @Override
    public Monster createFireType() {
        return new FireDragon(createRandomHealth(), createRandomPower());
    }

    @Override
    public Monster createGrassType() {
        return new GrassDragon(createRandomHealth(), createRandomPower());
    }

    @Override
    public Monster createWaterType() {
        return new WaterDragon(createRandomHealth(), createRandomPower());
    }

    private int createRandomHealth() {
        // geeft een random nummer tussen de minimale en maximale waardes boven aangegeven
        return(ThreadLocalRandom.current().nextInt(minDragonHealth, maxDragonHealth + 1));
    }

    private int createRandomPower() {
        // geeft een random nummer tussen de minimale en maximale waardes boven aangegeven
        return(ThreadLocalRandom.current().nextInt(minDragonPower, maxDragonPower + 1));
    }
}
