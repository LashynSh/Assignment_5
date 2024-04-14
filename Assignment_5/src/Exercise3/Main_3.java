package Exercise3;

class Furniture {
    private String name;
    private String style;
    private String material;
    private float price;

    public Furniture(String name, String style, String material, float price) {
        this.name = name;
        this.style = style;
        this.material = material;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "name='" + name + '\'' +
                ", style='" + style + '\'' +
                ", material='" + material + '\'' +
                ", price=" + price +
                '}';
    }
}

abstract class FurnitureFactory {
    public abstract Furniture createChair();
    public abstract Furniture createTable();
    public abstract Furniture createSofa();
}

class ModernWoodFactory extends FurnitureFactory {
    @Override
    public Furniture createChair() {
        return new Furniture("Modern Wood Chair", "Modern", "Wood", 100);
    }

    @Override
    public Furniture createTable() {
        return new Furniture("Modern Wood Table", "Modern", "Wood", 200);
    }

    @Override
    public Furniture createSofa() {
        return new Furniture("Modern Wood Sofa", "Modern", "Wood", 300);
    }
}

class TraditionalMetalFactory extends FurnitureFactory {
    @Override
    public Furniture createChair() {
        return new Furniture("Traditional Metal Chair", "Traditional", "Metal", 120);
    }

    @Override
    public Furniture createTable() {
        return new Furniture("Traditional Metal Table", "Traditional", "Metal", 220);
    }

    @Override
    public Furniture createSofa() {
        return new Furniture("Traditional Metal Sofa", "Traditional", "Metal", 320);
    }
}

class IndustrialGlassFactory extends FurnitureFactory {
    @Override
    public Furniture createChair() {
        return new Furniture("Industrial Glass Chair", "Industrial", "Glass", 150);
    }

    @Override
    public Furniture createTable() {
        return new Furniture("Industrial Glass Table", "Industrial", "Glass", 250);
    }

    @Override
    public Furniture createSofa() {
        return new Furniture("Industrial Glass Sofa", "Industrial", "Glass", 350);
    }
}

class FurnitureCreator {
    private FurnitureFactory factory;

    public void setFactory(FurnitureFactory factory) {
        this.factory = factory;
    }

    public Furniture createChair() {
        return factory.createChair();
    }

    public Furniture createTable() {
        return factory.createTable();
    }

    public Furniture createSofa() {
        return factory.createSofa();
    }
}

public class Main_3 {
    public static void main(String[] args) {
        FurnitureCreator creator = new FurnitureCreator();

        creator.setFactory(new ModernWoodFactory());
        Furniture modernWoodChair = creator.createChair();
        Furniture modernWoodTable = creator.createTable();
        Furniture modernWoodSofa = creator.createSofa();

        creator.setFactory(new TraditionalMetalFactory());
        Furniture traditionalMetalChair = creator.createChair();
        Furniture traditionalMetalTable = creator.createTable();
        Furniture traditionalMetalSofa = creator.createSofa();

        creator.setFactory(new IndustrialGlassFactory());
        Furniture industrialGlassChair = creator.createChair();
        Furniture industrialGlassTable = creator.createTable();
        Furniture industrialGlassSofa = creator.createSofa();

        System.out.println("Modern Wood Chair: " + modernWoodChair);
        System.out.println("Modern Wood Table: " + modernWoodTable);
        System.out.println("Modern Wood Sofa: " + modernWoodSofa);

        System.out.println("Traditional Metal Chair: " + traditionalMetalChair);
        System.out.println("Traditional Metal Table: " + traditionalMetalTable);
        System.out.println("Traditional Metal Sofa: " + traditionalMetalSofa);

        System.out.println("Industrial Glass Chair: " + industrialGlassChair);
        System.out.println("Industrial Glass Table: " + industrialGlassTable);
        System.out.println("Industrial Glass Sofa: " + industrialGlassSofa);

    }
}
