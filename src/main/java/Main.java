import java.util.Scanner;

public class Main {

    public static void main(String[] argv) {

        Scanner in = new Scanner(System.in);
        String event = "";
        String name = "";
        Zoo zoo = new Zoo();
        AnimalType herbivore = AnimalType.HERBIVORE;
        AnimalType carnivore = AnimalType.CARNIVORE;
        AnimalType all = AnimalType.ALL;
        AnimalType thisType = AnimalType.ERROR;
        String path = Main.class.getClassLoader().getResource("animals.json").getPath();
        zoo.addAnimal(path);

        Trigger trigger = new Trigger(zoo);

        while (true){
            System.out.println("Введите событие (FEEDING, KEEPER_VISIT, MORNING, NIGHT, THUNDER, UPDATE_STATE, PRINT, STOP): ");
            event = in.next();
            if(event.equals(Events.STOP.getWord()))
                break;
            else if(event.equals(Events.PRINT.getWord())) {
                zoo.printAllStates();
            } else {
                System.out.println("Введите класс животных (CARNIVORE, HERBIVORE, ALL): ");
                name = in.next();
                switch (AnimalType.valueOf(name)){
                    case CARNIVORE:
                        thisType = carnivore;
                        break;
                    case HERBIVORE:
                        thisType = herbivore;
                        break;
                    case ALL:
                        thisType = all;
                        break;
                    default:
                        thisType = AnimalType.ERROR;
                        System.out.println("Тип животного введент неверно.");
                }
                switch (Events.valueOf(event)){
                    case FEEDING:
                        trigger.feedAnimal(thisType);
                        break;
                    case KEEPER_VISIT:
                        trigger.visit(thisType);
                        break;
                    case MORNING:
                        trigger.setMorning();
                        break;
                    case NIGHT:
                        trigger.setNight();
                        break;
                    case THUNDER:
                        trigger.setThunder();
                        break;
                    case UPDATE_STATE:
                        zoo.setCalmForAll();
                        break;
                    default:
                        System.out.println("Была введена неизвестная команда");
                }
            }
            zoo.performAction(Events.UPDATE_STATE);
            System.out.println();
        }


    }
}
