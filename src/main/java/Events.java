//Возможные события в окружающем мире

import lombok.Getter;

@Getter
public enum Events {
    //Посещение смотрителя
    KEEPER_VISIT("KEEPER_VISIT"),

    //Кормежка закончилась
    FEEDING("FEEDING"),

    //Ночь
    NIGHT("NIGHT"),

    //Утро
    MORNING("MORNING"),

    //Гремит гром
    THUNDER("THUNDER"),

    //Обновить состояние активности
    UPDATE_STATE("UPDATE_STATE"),

    //Вывод информации о состоянии активности животных
    PRINT("PRINT"),

    //Завершаем выполнение программы
    STOP("STOP");

    private final String word;

    Events(String word){
        this.word = word;
    }
}
