import org.junit.jupiter.api.*;

public class TriggerTest {

    private static Zoo zoo;
    private static Trigger trigger;
    private static String path;

    private AnimalType carnivore = AnimalType.CARNIVORE;
    private AnimalType herbivore = AnimalType.HERBIVORE;

    @BeforeEach
    public void initNew(){ zoo = new Zoo();
        path = ZooTest.class.getClassLoader().getResource("animals.json").getPath();
        zoo.addAnimal(path);
        trigger = new Trigger(zoo);}

    @Test
    public void visit(){
        trigger.visit(herbivore);
        Assertions.assertEquals(AnimalState.MAKE_NOISE, zoo.getStateHerbivores(), "Травоядные не шумят");
        trigger.visit(carnivore);
        Assertions.assertEquals(AnimalState.MAKE_NOISE, zoo.getStateHerbivores(), "Травоядные не шумят");
    }

    @Test
    public void morning(){
        trigger.setMorning();
        Assertions.assertEquals(AnimalState.CALM, zoo.getStateHerbivores(), "Травоядные не проснулись или шумели всю ночь");
        Assertions.assertEquals(AnimalState.CALM, zoo.getStateHerbivores(), "Плотоядные не проснулись или шумели всю ночь");
    }
}
