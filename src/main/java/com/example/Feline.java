// Пакет, в котором находится класс Feline
package com.example;

// Импорт класса List из пакета java.util для работы с коллекциями
import java.util.List;

// Объявление класса Feline, который наследуется от класса Animal и реализует интерфейс Predator
public class Feline extends Animal implements Predator {

    // Переопределение метода eatMeat из интерфейса Predator
    @Override
    public List<String> eatMeat() throws Exception {
        // Метод вызывает метод getFood у класса Animal с параметром "Хищник" и возвращает результат
        return getFood("Хищник");
    }

    // Переопределение метода getFamily из класса Animal
    @Override
    public String getFamily() {
        // Метод возвращает строку, содержащую информацию о семействе кошачьих
        return "Кошачьи";
    }

    // Объявление метода getKittens без параметров
    public int getKittens() {
        // Метод вызывает метод getKittens с параметром 1 и возвращает результат
        return getKittens(1);
    }

    // Объявление метода getKittens с параметром kittensCount
    public int getKittens(int kittensCount) {
        // Метод возвращает значение kittensCount
        return kittensCount;
    }
}