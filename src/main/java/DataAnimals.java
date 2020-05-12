import lombok.Getter;
import java.util.List;

/**
 * Класс, для перевода данных из json
 */
@Getter
public class DataAnimals {

    // Список с плотоядными
    private List<Carnivore> carnivores;

    //Список с травоядными
    private List<Herbivore> herbivores;
}
