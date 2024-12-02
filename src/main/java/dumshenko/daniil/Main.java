package dumshenko.daniil;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        Predicate<Integer> isSimpleNumber = x -> {
            if (x < 2) return false;
            for (int i = 2; i <= Math.sqrt(x); i++) {
                if (x % i == 0) return false;
            }
            return true;
        };

        System.out.println(isSimpleNumber.test(6));
        System.out.println(isSimpleNumber.test(7));

        List<Integer> generatedNumbers = new ArrayList<>();

        Consumer<Integer> generateNumbersAndPutThemInArrayList = (x) -> {
            if (x <= 0) throw new IllegalArgumentException("Wrong Number");
            for (int i = 0; i <= x; i++) {
                generatedNumbers.add(i);
            }
            System.out.println(generatedNumbers);
        };

        generateNumbersAndPutThemInArrayList.accept(10);

        Supplier<DayOfWeek> dayOfWeek = () -> LocalDate.now().getDayOfWeek();
        System.out.println(dayOfWeek.get());

        Function<Double, Long> castingDoubleToLong = x -> x.longValue();

        Double ourTestNumber = 1200000000000001.12312312345;
        Long result = castingDoubleToLong.apply(ourTestNumber);
        System.out.println(result);

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
        Integer fibResult1 = calculateFibonacci.apply(7);
        Integer fibResult2 = calculateFibonacci.apply(13);
        System.out.println(fibResult1);

        // TODO Реалізувати бінарний оператор.

        BinaryOperator<Integer> calculateFibonacciSum = Integer::sum;
    }
}
