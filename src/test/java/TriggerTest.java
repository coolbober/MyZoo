import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TriggerTest {

    private static Zoo zoo;
    private static Trigger trigger;
    private static String path;

    private AnimalType carnivore = AnimalType.CARNIVORE;
    private AnimalType herbivore = AnimalType.HERBIVORE;

    @BeforeAll
    static void init(){
        zoo = new Zoo();
        path = ZooTest.class.getClassLoader().getResource("animals.json").getPath();
        zoo.addAnimal(path);
        trigger = new Trigger(zoo);
    }

    @Test
    public void visit(){
        trigger.visit(herbivore);
        System.out.println(zoo.getStateHerbivores());

        trigger.visit(carnivore);
        System.out.println(zoo.getStateCarnivores());
    }
}
