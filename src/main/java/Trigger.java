public class Trigger {

    private Zoo zoo;

    public Trigger (Zoo zoo){
        this.zoo = zoo;
    }

    void visit(AnimalType animalType){
        zoo.performAction(Events.KEEPER_VISIT, animalType);
    }

    void feedAnimal(AnimalType animalType) {
        zoo.performAction(Events.FEEDING, animalType);
    }

    void setMorning(){
        zoo.performAction(Events.MORNING);
    }

    void setNight(){
        zoo.performAction(Events.NIGHT);
    }

    void setThunder(){
        zoo.performAction(Events.THUNDER);
    }
}
