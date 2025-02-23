// Пакет, в котором находится интерфейс Predator
package com.example;

// Импорт класса List из пакета java.util для работы с коллекциями
import java.util.List;

// Объявление интерфейса Predator
public interface Predator {

    // Объявление метода eatMeat, который возвращает список строк и может генерировать исключение Exception
    List<String> eatMeat() throws Exception;

}