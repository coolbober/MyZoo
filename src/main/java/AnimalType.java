public enum AnimalType {

    /**
     * Список значений животных, которые нужны для определения объекта воздействия внешних факторов.
     * Воздействие может быть направлено на плотоядных (CARNIVORE), травоядных (HERBIVORE) и всех (ALL).
     * Случай с неверным введением вида объекта считается ошибочным и принимает значение ERROR.
     */
    CARNIVORE("CARNIVORE"),

    HERBIVORE("HERBIVORE"),

    ALL("ALL"),

    ERROR("Ошибка");

    String word;

    AnimalType(String word){
        this.word = word;
    }
}
