// Пакет, в котором находится класс AnimalTest
package com.example;

// Импорт класса Test из пакета org.junit для написания тестов
import org.junit.Test;

// Импорт класса List из пакета java.util для работы с коллекциями
import java.util.List;

// Импорт статических методов assertEquals и assertThrows из пакета org.junit.Assert для проверки результатов тестов
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// Объявление класса AnimalTest для тестирования класса Animal
public class AnimalTest {

    // Объявление метода getFoodTest для тестирования метода getFood класса Animal
    @Test
    public void getFoodTest() throws Exception {
        // Создание объекта animal класса Animal
        Animal animal = new Animal();

        // Определение ожидаемого результата метода getFood для травоядного животного
        List<String> expectedFoods = List.of("Трава", "Различные растения");

        // Проверка результата метода getFood для травоядного животного
        assertEquals(expectedFoods, animal.getFood("Травоядное"));
    }

    // Объявление метода getFoodErrorMessageTest для тестирования ошибки метода getFood класса Animal
    @Test
    public void getFoodErrorMessageTest() {
        // Создание объекта animal класса Animal
        Animal animal = new Animal();

        // Определение ожидаемого сообщения об ошибке метода getFood для неизвестного вида животного
        String errorMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";

        // Проверка результата метода getFood для неизвестного вида животного и сравнение с ожидаемым сообщением об ошибке
        Exception exception = assertThrows(Exception.class, () -> animal.getFood("Мышь"));
        assertEquals(errorMessage, exception.getMessage());
    }

    // Объявление метода getFamilyTest для тестирования метода getFamily класса Animal
    @Test
    public void getFamilyTest() {
        // Создание объекта animal класса Animal
        Animal animal = new Animal();

        // Определение ожидаемого результата метода getFamily
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

        // Проверка результата метода getFamily
        assertEquals(expected, animal.getFamily());
    }
}