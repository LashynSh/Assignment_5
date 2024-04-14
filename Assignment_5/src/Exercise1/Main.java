package Exercise1;

import java.util.ArrayList;
import java.util.List;

class Character {
    private String name;
    private Appearance appearance;
    private List<Ability> abilities;
    private List<Equipment> equipment;
    private Attribute attributes;

    public Character(String name, Appearance appearance, List<Ability> abilities, List<Equipment> equipment, Attribute attributes) {
        this.name = name;
        this.appearance = appearance;
        this.abilities = abilities;
        this.equipment = equipment;
        this.attributes = attributes;
    }

    public void customizeAppearance(Appearance appearance) {
        this.appearance = appearance;
    }

    public void addAbility(Ability ability) {
        this.abilities.add(ability);
    }

    public void addEquipment(Equipment equipment) {
        this.equipment.add(equipment);
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", appearance=" + appearance +
                ", abilities=" + abilities +
                ", equipment=" + equipment +
                ", attributes=" + attributes +
                '}';
    }
}

abstract class CharacterFactory {
    public abstract Character createCharacter(String name);
}

class WarriorFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        return new Character(name, new Appearance(), new ArrayList<>(), new ArrayList<>(), new Attribute());
    }
}

class MageFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        return new Character(name, new Appearance(), new ArrayList<>(), new ArrayList<>(), new Attribute());
    }
}

class ArcherFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        return new Character(name, new Appearance(), new ArrayList<>(), new ArrayList<>(), new Attribute());
    }
}

class Appearance {
    @Override
    public String toString() {
        return "Appearance{}";
    }
}

class Ability {
    @Override
    public String toString() {
        return "Ability{}";
    }
}

class Equipment {
    @Override
    public String toString() {
        return "Equipment{}";
    }
}

class Attribute {
    @Override
    public String toString() {
        return "Attribute{}";
    }
}

class CharacterCreator {
    private CharacterFactory factory;

    public void setFactory(CharacterFactory factory) {
        this.factory = factory;
    }

    public Character createCharacter(String name) {
        return factory.createCharacter(name);
    }
}

public class Main {
    public static void main(String[] args) {
        CharacterCreator creator = new CharacterCreator();

        creator.setFactory(new WarriorFactory());
        Character warrior = creator.createCharacter("Warrior Bob");
        warrior.customizeAppearance(new Appearance(/* Custom appearance parameters */));
        warrior.addAbility(new Ability(/* Custom ability parameters */));
        warrior.addEquipment(new Equipment(/* Custom equipment parameters */));

        creator.setFactory(new MageFactory());
        Character mage = creator.createCharacter("Mage Alice");
        mage.customizeAppearance(new Appearance(/* Custom appearance parameters */));
        mage.addAbility(new Ability(/* Custom ability parameters */));
        mage.addEquipment(new Equipment(/* Custom equipment parameters */));

        creator.setFactory(new ArcherFactory());
        Character archer = creator.createCharacter("Archer John");
        archer.customizeAppearance(new Appearance(/* Custom appearance parameters */));
        archer.addAbility(new Ability(/* Custom ability parameters */));
        archer.addEquipment(new Equipment(/* Custom equipment parameters */));

        System.out.println(warrior);
        System.out.println(mage);
        System.out.println(archer);
    }
}
