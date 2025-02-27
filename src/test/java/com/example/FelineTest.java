// Пакет, в котором находится класс FelineTest
package com.example;

// Импорт класса Assert из пакета org.junit для проверки результатов тестов
import org.junit.Assert;

// Импорт класса Before из пакета org.junit для инициализации тестов
import org.junit.Before;

// Импорт класса Test из пакета org.junit для написания тестов
import org.junit.Test;

// Импорт класса List из пакета java.util для работы с коллекциями
import java.util.List;

// Импорт класса Random из пакета java.util для генерации случайных чисел
import java.util.Random;

// Объявление класса FelineTest для тестирования класса Feline
public class FelineTest {

    // Объявление переменной feline типа Feline для тестирования класса Feline
    private Feline feline;

    // Метод инициализации тестов, который вызывается перед каждым тестом
    @Before
    public void setUp() {
        // Создание объекта feline класса Feline
        feline = new Feline();
    }

    // Объявление метода eatMeatTest для тестирования метода eatMeat класса Feline
    @Test
    public void eatMeatTest() throws Exception {
        // Определение ожидаемого результата метода eatMeat
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        // Вызов метода eatMeat у объекта feline и получение фактического результата
        List<String> actual = feline.eatMeat();

        // Проверка результата метода eatMeat
        Assert.assertEquals(expected, actual);
    }

    // Объявление метода getFamilyTest для тестирования метода getFamily класса Feline
    @Test
    public void getFamilyTest() {
        // Определение ожидаемого результата метода getFamily
        String expected = "Кошачьи";

        // Вызов метода getFamily у объекта feline и получение фактического результата
        String actual = feline.getFamily();

        // Проверка результата метода getFamily
        Assert.assertEquals(expected, actual);
    }

    // Объявление метода getKittensWithoutParameterTest для тестирования метода getKittens без параметра класса Feline
    @Test
    public void getKittensWithoutParameterTest() {
        // Определение ожидаемого результата метода getKittens без параметра
        int expected = 1;

        // Вызов метода getKittens без параметра у объекта feline и получение фактического результата
        int actual = feline.getKittens();

        // Проверка результата метода getKittens без параметра
        Assert.assertEquals(expected, actual);
    }

    // Объявление метода getKittensWithParameterTest для тестирования метода getKittens с параметром класса Feline
    @Test
    public void getKittensWithParameterTest() {
        // Генерация случайного числа для передачи в метод getKittens с параметром
        int expected = new Random().nextInt(20);

        // Вызов метода getKittens с параметром у объекта feline и получение фактического результата
        int actual = feline.getKittens(expected);

        // Проверка результата метода getKittens с параметром
        Assert.assertEquals(expected, actual);
    }
}