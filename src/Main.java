import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.concurrent.ThreadLocalRandom.current;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wat is je naam?");
        String spelerNaam = scanner.nextLine();
        System.out.println("Hoeveel health heb je?");
        int spelerHealth = scanner.nextInt();
        System.out.println("Wat is je power?");
        int spelerPower = scanner.nextInt();
        System.out.println("Welk element ben je? Water / Fire / Grass");
        String spelerElement = scanner.next();

        Speler speler = new Speler(spelerNaam, spelerHealth, spelerPower, spelerElement);
        System.out.println(" ");
        System.out.println("Het spel is begonnen " + speler.name + "!");
        System.out.println(" ");
        System.out.println(" ");

        while(speler.health > 0) {
            System.out.println("Welk gebied wil je bezoeken? Desert / Forest / Arctics");
            String area = scanner.next();

            Monster monster;
            switch (area) {
                case "Desert":
                case "desert":
                    monster = createNewMonster("desert");
                    break;
                case "Forest":
                case "forest":
                    monster = createNewMonster("forest");
                    break;
                case "Arctics":
                case "arctics":
                    monster = createNewMonster("arctics");
                    break;
                default:
                    monster = createNewMonster("");
            }

            monster.showData();
            fight(speler, monster);

        }

        System.out.println("Speler " + speler.name + " is gedood! Totale kills: " + speler.kills);
        System.out.println("G A M E O V E R !");
    }

    private static Monster createNewMonster(String area) {

        MouseFactory mouseMaker = new MouseFactory();
        BearFactory bearMaker = new BearFactory();
        DragonFactory dragonMaker = new DragonFactory();

        Monster monster;
        int random = ThreadLocalRandom.current().nextInt(1, 20 + 1);

        if(random < 12) {
            switch (area) {
                case "desert":
                    monster = mouseMaker.createFireType();
                    break;
                case "arctics":
                    monster = mouseMaker.createWaterType();
                    break;
                case "forest":
                    monster = mouseMaker.createGrassType();
                    break;
                default:
                    monster = mouseMaker.createFireType();
            }
        } else if (random < 20) {
            switch (area) {
                case "desert":
                    monster = bearMaker.createFireType();
                    break;
                case "arctics":
                    monster = bearMaker.createWaterType();
                    break;
                case "forest":
                    monster = bearMaker.createGrassType();
                    break;
                default:
                    monster = bearMaker.createFireType();
            }
        } else {
            switch (area) {
                case "desert":
                    monster = dragonMaker.createFireType();
                    break;
                case "arctics":
                    monster = dragonMaker.createWaterType();
                    break;
                case "forest":
                    monster = dragonMaker.createGrassType();
                    break;
                default:
                    monster = dragonMaker.createFireType();
            }
        }

        return monster;
    }

    private static void fight(Speler speler, Monster monster) {

        int spelerBattlePower = speler.power;
        int monsterBattlePower = monster.getPower();

        if (speler.element.equals("grass") && monster.getElement().equals("water") ||
            speler.element.equals("fire") && monster.getElement().equals("grass") ||
            speler.element.equals("water") && monster.getElement().equals("fire") )
        {
            spelerBattlePower = spelerBattlePower * 2;
        }
        if (monster.getElement().equals("grass") && speler.element.equals("water") ||
            monster.getElement().equals("fire") && speler.element.equals("grass") ||
            monster.getElement().equals("water") && speler.element.equals("fire") )
        {
            monsterBattlePower = monsterBattlePower * 2;
        }

        while(speler.health > 0 && monster.getHealth() > 0) {
            System.out.println(" ");
            speler.health = speler.health - monsterBattlePower;
            System.out.println("Speler:  " + speler.health + "/" + spelerBattlePower);
            monster.setHealth(monster.getHealth() - spelerBattlePower);
            System.out.println("Monster: " + monster.getHealth() + "/" + monsterBattlePower);

        }

        if(monster.getHealth() < 1) {
            System.out.println("Je hebt het " + monster.getElement() + " monster verslagen en je hebt nog " + speler.health + " health over.");
            speler.addKill();
        }
    }
}
