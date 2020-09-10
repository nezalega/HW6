package HW6_1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


//Не использовать циклы (for/while/do-while). Сгенерировать 100 рандомных Long чисел в диапазоне
// от 0 до 100. Каждое число умножить на PI и отнять 20. Отфильтровать, оставив числа меньшие 100.
// Отсортировать по возрастанию. Пропустив первые 3 числа произвести следующие операции:
//Преобразовать лист чисел в Map (операция collect), где ключом является само число, а значением строка:
// ("Number: " + value).
public class HW1 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        List<Long> mylist = new ArrayList<Long>();
        mylist = Stream.generate(() -> new Random().nextLong())
                .filter(a -> a <= 100)
                .filter(a -> a > 0)
                .limit(100)
                .map(a -> (long) ((long) a * Math.PI - 20))
                .filter(a -> a <= 100)
                .sorted().collect(Collectors.toList());

        Map<Long, Object> mymap = mylist.stream().skip(3).distinct()
                .collect(Collectors.toMap(Long::longValue, x -> " number: " +String.valueOf(x)));

        System.out.println(mymap.toString());


    }
}