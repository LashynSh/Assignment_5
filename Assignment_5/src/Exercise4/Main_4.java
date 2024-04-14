package Exercise4;

interface Character {
    String getName();
    String getCharacterClass();
    Weapon getWeapon();
    int getHealth();
    int getMana();
}

interface Weapon {
    String getType();
    int getDamage();
    int getSpeed();
    int getRange();
}

// Step 3: Define an abstract CharacterFactory class
abstract class CharacterFactory {
    public abstract Character createCharacter();
    public abstract Weapon createWeapon();
}

class WarriorSwordFactory extends CharacterFactory {
    @Override
    public Character createCharacter() {
        return new ConcreteCharacter("Warrior", "Warrior", createWeapon(), 100, 50);
    }

    @Override
    public Weapon createWeapon() {
        return new ConcreteWeapon("Sword", 20, 10, 5);
    }
}

class MageStaffFactory extends CharacterFactory {
    @Override
    public Character createCharacter() {
        return new ConcreteCharacter("Mage", "Mage", createWeapon(), 80, 100);
    }

    @Override
    public Weapon createWeapon() {
        return new ConcreteWeapon("Staff", 15, 15, 8);
    }
}

class ArcherBowFactory extends CharacterFactory {
    @Override
    public Character createCharacter() {
        return new ConcreteCharacter("Archer", "Archer", createWeapon(), 90, 70);
    }

    @Override
    public Weapon createWeapon() {
        return new ConcreteWeapon("Bow", 18, 12, 10);
    }
}

class ConcreteCharacter implements Character {
    private String name;
    private String characterClass;
    private Weapon weapon;
    private int health;
    private int mana;

    public ConcreteCharacter(String name, String characterClass, Weapon weapon, int health, int mana) {
        this.name = name;
        this.characterClass = characterClass;
        this.weapon = weapon;
        this.health = health;
        this.mana = mana;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCharacterClass() {
        return characterClass;
    }

    @Override
    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", characterClass='" + characterClass + '\'' +
                ", weapon=" + weapon +
                ", health=" + health +
                ", mana=" + mana +
                '}';
    }
}

class ConcreteWeapon implements Weapon {
    private String type;
    private int damage;
    private int speed;
    private int range;

    public ConcreteWeapon(String type, int damage, int speed, int range) {
        this.type = type;
        this.damage = damage;
        this.speed = speed;
        this.range = range;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public int getRange() {
        return range;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "type='" + type + '\'' +
                ", damage=" + damage +
                ", speed=" + speed +
                ", range=" + range +
                '}';
    }
}

class CharacterCreator {
    private CharacterFactory factory;

    public void setFactory(CharacterFactory factory) {
        this.factory = factory;
    }

    public Character createCharacter() {
        return factory.createCharacter();
    }
}

public class Main_4 {
    public static void main(String[] args) {
        CharacterCreator creator = new CharacterCreator();

        creator.setFactory(new WarriorSwordFactory());
        Character warrior = creator.createCharacter();

        creator.setFactory(new MageStaffFactory());
        Character mage = creator.createCharacter();

        creator.setFactory(new ArcherBowFactory());
        Character archer = creator.createCharacter();

        System.out.println("Warrior: " + warrior);
        System.out.println("Mage: " + mage);
        System.out.println("Archer: " + archer);

    }
}

