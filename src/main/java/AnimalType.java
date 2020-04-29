public enum AnimalType {

    //Плотоядные животные
    CARNIVORE("CARNIVORE"),

    //Травоядные животные
    HERBIVORE("HERBIVORE"),

    //Все животные
    ALL("ALL"),

    //Для случая неверного ввода
    ERROR("Ошибка");

    String word;

    AnimalType(String word){
        this.word = word;
    }
}
