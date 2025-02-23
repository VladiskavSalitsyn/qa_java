// Пакет, в котором находится класс CatTest
package com.example;

// Импорт класса Assert из пакета org.junit для проверки результатов тестов
import org.junit.Assert;

// Импорт класса Before из пакета org.junit для инициализации тестов
import org.junit.Before;

// Импорт класса Test из пакета org.junit для написания тестов
import org.junit.Test;

// Импорт класса RunWith из пакета org.junit.runner для запуска тестов
import org.junit.runner.RunWith;

// Импорт класса MockitoJUnitRunner из пакета org.mockito.junit для использования Mockito в тестах
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

// Импорт класса List из пакета java.util для работы с коллекциями
import java.util.List;

// Указание, что тесты должны быть запущены с помощью MockitoJUnitRunner
@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    // Объявление мок-объекта feline типа Feline для имитации поведения класса Feline
    @Mock
    Feline feline;

    // Объявление переменной cat типа Cat для тестирования класса Cat
    private Cat cat;

    // Метод инициализации тестов, который вызывается перед каждым тестом
    @Before
    public void setUp() {
        // Создание объекта cat класса Cat с мок-объектом feline
        cat = new Cat(feline);
    }

    // Объявление метода testCatSound для тестирования метода getSound класса Cat
    @Test
    public void testCatSound() {
        // Определение ожидаемого результата метода getSound
        String expected = "Мяу";

        // Вызов метода getSound у объекта cat и получение фактического результата
        String actual = cat.getSound();

        // Проверка результата метода getSound
        Assert.assertEquals(expected, actual);
    }

    // Объявление метода testCatFood для тестирования метода getFood класса Cat
    @Test
    public void testCatFood() throws Exception {
        // Определение ожидаемого результата метода getFood
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        // Настройка мок-объекта feline для имитации поведения метода eatMeat
        Mockito.when(feline.eatMeat()).thenReturn(expected);

        // Вызов метода getFood у объекта cat и получение фактического результата
        List<String> actual = cat.getFood();

        // Проверка результата метода getFood
        Assert.assertEquals(expected, actual);
    }
}