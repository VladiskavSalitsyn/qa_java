// Пакет, в котором находится класс LionParameterizedTest
package com.example;

// Импорт класса Assert из пакета org.junit для проверки результатов тестов
import org.junit.Assert;

// Импорт класса Before из пакета org.junit для инициализации тестов
import org.junit.Before;

// Импорт класса Test из пакета org.junit для написания тестов
import org.junit.Test;

// Импорт класса RunWith из пакета org.junit.runner для запуска тестов
import org.junit.runner.RunWith;

// Импорт класса Parameterized из пакета org.junit.runners для параметризованных тестов
import org.junit.runners.Parameterized;

// Импорт класса Mockito из пакета org.mockito для имитации поведения классов
import org.mockito.Mockito;

// Объявление класса LionParameterizedTest для параметризованного тестирования класса Lion
@RunWith(Parameterized.class)
public class LionParameterizedTest {

    // Объявление переменной feline типа Feline для имитации поведения класса Feline
    private Feline feline;

    // Объявление переменной lion типа Lion для тестирования класса Lion
    private Lion lion;

    // Объявление переменной sex типа String для передачи пола льва
    private String sex;

    // Объявление переменной hasMane типа boolean для передачи информации о наличии гривы у льва
    private boolean hasMane;

    // Объявление метода data для определения параметров теста
    @Parameterized.Parameters
    public static Object[][] data() {
        // Возвращение массива параметров для теста
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    // Объявление конструктора класса LionParameterizedTest для инициализации переменных
    public LionParameterizedTest(String sex, boolean hasMane) {
        // Инициализация переменных sex и hasMane
        this.sex = sex;
        this.hasMane = hasMane;
    }

    // Метод инициализации тестов, который вызывается перед каждым тестом
    @Before
    public void setUp() throws Exception {
        // Создание мок-объекта feline класса Feline
        feline = Mockito.mock(Feline.class);

        // Создание объекта lion класса Lion с мок-объектом feline и полом sex
        lion = new Lion(feline, sex);
    }

    // Объявление метода testVerifyLionHasMane для тестирования метода doesHaveMane класса Lion
    @Test
    public void testVerifyLionHasMane() {
        // Определение ожидаемого результата метода doesHaveMane
        boolean expectedHasMane = hasMane;

        // Вызов метода doesHaveMane у объекта lion и получение фактического результата
        boolean actualHasMane = lion.doesHaveMane();

        // Проверка результата метода doesHaveMane
        Assert.assertEquals(expectedHasMane, actualHasMane);
    }
}