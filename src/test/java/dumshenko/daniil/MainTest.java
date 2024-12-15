package dumshenko.daniil;

/*Тести зробив за допомогою чату, оскільки не дуже зрозумів як тут та що тут тестувати.
Насамперед рядки з 20 по 27. Я навіть і не думав, що в // Given можна вставити моє рішення цього завдання повністю,
щоб створити умову для When та Then.
 Також в рядках 55 та 56,
*/

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void shouldTestIfNumberIsSimple() {
        // Given
        Predicate<Integer> isSimpleNumber = x -> {
            if (x < 2) return false;
            for (int i = 2; i <= Math.sqrt(x); i++) {
                if (x % i == 0) return false;
            }
            return true;
        };

        // When
        boolean result1 = isSimpleNumber.test(6);
        boolean result2 = isSimpleNumber.test(7);

        // Then
        assertFalse(result1);
        assertTrue(result2);
    }

    @Test
    void shouldGenerateNumbersAndPutThemInArrayList() {
        // Given
        List<Integer> generatedNumbers = new ArrayList<>();
        Consumer<Integer> generateNumbersAndPutThemInArrayList = (x) -> {
            if (x <= 0) throw new IllegalArgumentException("Wrong Number");
            for (int i = 0; i <= x; i++) {
                generatedNumbers.add(i);
            }
        };

        // When
        generateNumbersAndPutThemInArrayList.accept(10);

        // Then
        assertEquals(11, generatedNumbers.size());
        assertEquals(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10), generatedNumbers);
    }

    @Test
    void shouldReturnCurrentDayOfWeek() {
        // Given
        Supplier<DayOfWeek> dayOfWeek = () -> LocalDate.now().getDayOfWeek();

        // When
        DayOfWeek result = dayOfWeek.get();

        // Then
        assertEquals(LocalDate.now().getDayOfWeek(), result);
    }

    @Test
    void shouldCastDoubleToLong() {
        // Given
        Function<Double, Long> castingDoubleToLong = x -> x.longValue();
        Double testNumber = 1200000000000001.12312312345;

        // When
        Long result = castingDoubleToLong.apply(testNumber);

        // Then
        assertEquals(1200000000000001L, result);
    }

    @Test
    void shouldCalculateFibonacciNumber() {
        // Given
        UnaryOperator<Integer> calculateFibonacci = x -> {
            if (x == 0) return 0;
            if (x == 1) return 1;

            int a = 0, b = 1, fib = 0;
            for (int i = 2; i <= x; i++) {
                fib = a + b;
                a = b;
                b = fib;
            }
            return fib;
        };

        // When
        Integer fib7 = calculateFibonacci.apply(7);
        Integer fib13 = calculateFibonacci.apply(13);

        // Then
        assertEquals(13, fib7);
        assertEquals(233, fib13);
    }

    @Test
    void shouldReturnSumOfTwoFibonacciNumbers() { // Цей тест вже сам написав на основі того, чому навчився, розібравши тести які написав за допомогою чату.
        // Given
        UnaryOperator<Integer> calculateFibonacci = x -> {
            if (x == 0) return 0;
            if (x == 1) return 1;

            int a = 0, b = 1, fib = 0;
            for (int i = 2; i <= x; i++) {
                fib = a + b;
                a = b;
                b = fib;
            }
            return fib;
        };

        BinaryOperator<Integer> calculateFibonacciSum = (x, y) -> calculateFibonacci.apply(x) + calculateFibonacci.apply(y);

        // When
        Integer sumOfFibResult = calculateFibonacciSum.apply(7, 13);

        // Then
        assertEquals(246, sumOfFibResult);
    }
}
