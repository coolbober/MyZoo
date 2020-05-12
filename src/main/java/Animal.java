import lombok.*;

/**
 * Класс, описывающий общие признаки для животных
 */
@Getter
@Setter
abstract public class Animal {

    /**
     * kind - Вид плотоядного или хищника
     * count - количество животных одного вида
     * curState - текущая активность данного вида
     */
    protected String kind;
    protected int count;
    protected AnimalState curState;

    public Animal(){
        curState = AnimalState.CALM;
    }

    /**
     * Внешние воздействия на животных, из-за которых меняется поведение последних:
     * keepVisit - визит смотрителя
     * feeding - кормежка
     * night - ночь
     * morning - утро
     * thunder - гром
     * updateAnimalAction - обновление действия животного
     */
    //Внешние действия, влияющие на поведение животных
    abstract public void keepVisit();
    abstract public void feeding();
    abstract public void night();
    abstract public void morning();
    abstract public void thunder();
    abstract public void updateAnimalAction();

    /**
     * Установка действия, где
     * @param event значение, введенное с клавиатуры.
     */
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

    @Override
    public String toString(){
        return "Тип животного: " + kind + ". Количество таких животных: " + count + ". Текущая активность: " + curState;
    }

}
