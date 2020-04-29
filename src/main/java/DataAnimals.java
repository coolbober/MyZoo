
//Файл для трансформации json данных в Java

import lombok.Getter;

import java.util.List;

@Getter
public class DataAnimals {

    // Список с плотоядными
    private List<Carnivore> carnivores;

    //Список с травоядными
    private List<Herbivore> herbivores;
}
