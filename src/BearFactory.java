import java.util.concurrent.ThreadLocalRandom;

public class BearFactory implements MonsterFactory{

    private int minBearHealth = 100;
    private int maxBearHealth = 160;
    private int minBearPower = 10;
    private int maxBearPower = 20;

    @Override
    public Monster createFireType() {
        return new FireBear(createRandomHealth(), createRandomPower());
    }

    @Override
    public Monster createGrassType() {
        return new GrassBear(createRandomHealth(), createRandomPower());
    }

    @Override
    public Monster createWaterType() {
        return new WaterBear(createRandomHealth(), createRandomPower());
    }

    private int createRandomHealth() {
        // geeft een random nummer tussen de minimale en maximale waardes boven aangegeven
        return(ThreadLocalRandom.current().nextInt(minBearHealth, maxBearHealth + 1));
    }

    private int createRandomPower() {
        // geeft een random nummer tussen de minimale en maximale waardes boven aangegeven
        return(ThreadLocalRandom.current().nextInt(minBearPower, maxBearPower + 1));
    }
}

