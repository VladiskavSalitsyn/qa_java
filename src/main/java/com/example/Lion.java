// Пакет, в котором находится класс Lion
package com.example;

// Импорт класса List из пакета java.util для работы с коллекциями
import java.util.List;

// Объявление класса Lion
public class Lion {

    // Объявление переменной hasMane типа boolean для хранения информации о наличии гривы у льва
    boolean hasMane;

    // Объявление переменной feline типа Feline для хранения информации о кошачьем
    private Feline feline;

    // Объявление конструктора класса Lion, который принимает параметры feline типа Feline и sex типа String
    public Lion(Feline feline, String sex) throws Exception {
        // Инициализация переменной feline значением feline
        this.feline = feline;

        // Проверка значения sex
        if ("Самец".equals(sex)) {
            // Если sex равен "Самец", переменная hasMane устанавливается в true
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            // Если sex равен "Самка", переменная hasMane устанавливается в false
            hasMane = false;
        } else {
            // Если sex не равен ни "Самец", ни "Самка", метод генерирует исключение Exception
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    // Объявление метода getKittens, который возвращает количество котят
    public int getKittens() {
        // Метод вызывает метод getKittens у объекта feline и возвращает результат
        return feline.getKittens();
    }

    // Объявление метода doesHaveMane, который возвращает информацию о наличии гривы у льва
    public boolean doesHaveMane() {
        // Метод возвращает значение переменной hasMane
        return hasMane;
    }

    // Объявление метода getFood, который возвращает список строк и может генерировать исключение Exception
    public List<String> getFood() throws Exception {
        // Метод вызывает метод getFood у объекта feline с параметром "Хищник" и возвращает результат
        return feline.getFood("Хищник");
    }
}