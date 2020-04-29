import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Getter
public class Zoo {

    //Список всех животных
    private static List<Animal> zooAnimals;

    //Состояние активности плотоядных
    @Getter @Setter
    private static AnimalState stateCarnivores;

    //Состояние активности травоядных
    @Getter @Setter
    private static AnimalState stateHerbivores;

    //Инициализация зоопарка
    public Zoo(){
        zooAnimals = new LinkedList<Animal>();
        stateCarnivores = AnimalState.CALM;
        stateHerbivores = AnimalState.CALM;
    }

    public void addAnimal(String jsonPath){
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(jsonPath);
        try {
            DataAnimals dataAnimals = mapper.readValue(file, DataAnimals.class);
            zooAnimals.addAll(dataAnimals.getCarnivores());
            zooAnimals.addAll(dataAnimals.getHerbivores());
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException("Ошибка при трансформации json файла.");
        }
    }

    public void performAction(Events events, AnimalType type){
        switch (type){
            case CARNIVORE:
                for (Animal animal : zooAnimals) {
                    if(animal instanceof Carnivore) {
                        animal.updateState(events);
                    }
                }
                break;
            case HERBIVORE:
                for (Animal animal : zooAnimals){
                    if(animal instanceof  Herbivore)
                        animal.updateState(events);
                }
                break;
            case ALL:
                for (Animal animal : zooAnimals)
                    animal.updateState(events);
            default:
                System.out.println("Нет такого животного");
        }
    }

    public void performAction(Events events){
        for (Animal animal : zooAnimals)
            animal.updateState(events);
    }

    public void setCalmForAll(){
        setStateHerbivores(AnimalState.CALM);
        setStateCarnivores(AnimalState.CALM);
    }


    public void printAllStates(){
        System.out.println("---- ИНФОРМАЦИЯ О ТЕКУЩЕЙ АКТИВНОСТИ ЖИВОТНЫХ ----");
        System.out.println("Активность плотоядных: " + stateCarnivores);
        System.out.println("Активность травоядных: " + stateHerbivores);
    }
}
