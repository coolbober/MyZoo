public class Carnivore extends Animal {

    /**
     * Класс, описывающий реакцию плотоядных на различные внешние воздействия.
     */

    //Смотритель пришел к плотоядным
    public void keepVisit() {
        curState = AnimalState.MAKE_NOISE;
        Zoo.setStateCarnivores(AnimalState.MAKE_NOISE);
    }

    //Плотоядных покормили
    public void feeding() {
        setCurState(AnimalState.CALM);
        Zoo.setStateCarnivores(AnimalState.CALM);
    }

    //Наступила ночь
    public void night() {
        if(!Zoo.getStateCarnivores().equals(AnimalState.MAKE_NOISE) || !Zoo.getStateHerbivores().equals(AnimalState.MAKE_NOISE)){
            setCurState(AnimalState.SLEEP);
            Zoo.setStateCarnivores(AnimalState.SLEEP);
        } else {
            System.out.println(kind + " не спит.");
        }
    }

    //Наступило утро
    public void morning() {
        if (!Zoo.getStateCarnivores().equals(AnimalState.MAKE_NOISE)){
            setCurState(AnimalState.CALM);
            Zoo.setStateCarnivores(AnimalState.CALM);
        } else
            System.out.println(kind + " шумят.");
    }

    //Гремит гром
    public void thunder() {
        setCurState(AnimalState.MAKE_NOISE);
        Zoo.setStateCarnivores(AnimalState.MAKE_NOISE);
    }

    public void updateAnimalAction() {
        curState = Zoo.getStateCarnivores();
        if(Zoo.getStateHerbivores().equals(AnimalState.MAKE_NOISE))
            Zoo.setStateCarnivores(AnimalState.MAKE_NOISE);
    }
}
