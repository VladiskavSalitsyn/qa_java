// Пакет, в котором находится класс LionNonParameterizedTest
package com.example;

// Импорт класса Assert из пакета org.junit для проверки результатов тестов
import org.junit.Assert;

// Импорт класса Before из пакета org.junit для инициализации тестов
import org.junit.Before;

// Импорт класса Test из пакета org.junit для написания тестов
import org.junit.Test;

// Импорт класса Mockito из пакета org.mockito для имитации поведения классов
import org.mockito.Mockito;

// Импорт класса Arrays из пакета java.util для работы с массивами
import java.util.Arrays;

// Импорт класса List из пакета java.util для работы с коллекциями
import java.util.List;

// Объявление класса LionNonParameterizedTest для тестирования класса Lion
public class LionNonParameterizedTest {

    // Объявление переменной feline типа Feline для имитации поведения класса Feline
    private Feline feline;

    // Объявление переменной lion типа Lion для тестирования класса Lion
    private Lion lion;

    // Метод инициализации тестов, который вызывается перед каждым тестом
    @Before
    public void setUp() throws Exception {
        // Создание мок-объекта feline класса Feline
        feline = Mockito.mock(Feline.class);

        // Создание объекта lion класса Lion с мок-объектом feline и полом "Самец"
        lion = new Lion(feline, "Самец");
    }

    // Объявление метода testReturnCorrectNumberOfKittens для тестирования метода getKittens класса Lion
    @Test
    public void testReturnCorrectNumberOfKittens() {
        // Настройка мок-объекта feline для имитации поведения метода getKittens
        Mockito.when(feline.getKittens()).thenReturn(1);

        // Определение ожидаемого результата метода getKittens
        int expectedKittens = 1;

        // Вызов метода getKittens у объекта lion и получение фактического результата
        int actualKittens = lion.getKittens();

        // Проверка результата метода getKittens
        Assert.assertEquals(expectedKittens, actualKittens);
    }

    // Объявление метода testReturnCorrectFoodForLion для тестирования метода getFood класса Lion
    @Test
    public void testReturnCorrectFoodForLion() throws Exception {
        // Определение ожидаемого результата метода getFood
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");

        // Настройка мок-объекта feline для имитации поведения метода getFood
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);

        // Вызов метода getFood у объекта lion и получение фактического результата
        List<String> actualFood = lion.getFood();

        // Проверка результата метода getFood
        Assert.assertEquals(expectedFood, actualFood);
    }

    // Объявление метода testThrowExceptionForInvalidSex для тестирования исключения класса Lion
    @Test
    public void testThrowExceptionForInvalidSex() {
        // Проверка исключения класса Lion для некорректного значения пола
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            new Lion(feline, "Некорректное значение пола");
        });

        // Определение ожидаемого сообщения об ошибке
        String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";

        // Получение фактического сообщения об ошибке
        String actualMessage = exception.getMessage();

        // Проверка сообщения об ошибке
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }
}