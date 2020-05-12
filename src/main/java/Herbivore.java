public class Herbivore extends Animal {

    /**
     * Описание реакции травоядных животных.
     */

    //К травоядным пришел смотритель
    public void keepVisit() {
        setCurState(AnimalState.MAKE_NOISE);
        Zoo.setStateHerbivores(AnimalState.MAKE_NOISE);
    }

    //Травоядных покормили
    public void feeding() {
        setCurState(AnimalState.CALM);
        Zoo.setStateHerbivores(AnimalState.CALM);
    }

    //Наступила ночь
    public void night() {
        if(!Zoo.getStateCarnivores().equals(AnimalState.MAKE_NOISE) && !Zoo.getStateHerbivores().equals(AnimalState.MAKE_NOISE)){
            setCurState(AnimalState.SLEEP);
            Zoo.setStateHerbivores(AnimalState.SLEEP);
        } else
            System.out.println(kind + " шумел.");
    }

    //Наступило утро
    public void morning() {
        if(Zoo.getStateHerbivores().equals(AnimalState.SLEEP) && Zoo.getStateCarnivores().equals(AnimalState.SLEEP)){
            setCurState(AnimalState.CALM);
            Zoo.setStateHerbivores(AnimalState.CALM);
        } else
            System.out.println(kind + " не спит.");
    }

    //Гремит гром
    public void thunder() {
        setCurState(AnimalState.MAKE_NOISE);
        Zoo.setStateHerbivores(AnimalState.MAKE_NOISE);
    }

    public void updateAnimalAction() {
        curState = Zoo.getStateHerbivores();
    }
}
