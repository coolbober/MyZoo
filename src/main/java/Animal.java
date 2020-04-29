import lombok.*;

import java.awt.*;

@Getter
@Setter
abstract public class Animal {

    // Вид плотоядного или хищника
    protected String kind;

    //Количество такого животного
    protected int count;

    //Текущая активность
    protected AnimalState curState;

    public Animal(){
        curState = AnimalState.CALM;
    }

    //Внешние действия, влияющие на поведение животных
    abstract public void keepVisit();
    abstract public void feeding();
    abstract public void night();
    abstract public void morning();
    abstract public void thunder();
    abstract public void updateAnimalAction();

    public void updateState(Events event){
        switch (event){
            case NIGHT:
                night();
                break;
            case FEEDING:
                feeding();
                break;
            case MORNING:
                morning();
                break;
            case THUNDER:
                thunder();
                break;
            case KEEPER_VISIT:
                keepVisit();
                break;
            case UPDATE_STATE:
                updateAnimalAction();
                break;
            case STOP:
                break;
            default:
                System.out.println("Неизвестное состояние, попробуйте снова");
        }
    }

    public void printAboutAnimal(){
        System.out.println(toString());
    }

    @Override
    public String toString(){
        return "Тип животного: " + kind + ". Количество таких животных: " + count + ". Текущая активность: " + curState;
    }

}
