package lambda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.groupingByConcurrent;

public class ParallelMain {
    public static void main(String[] args) {
        List<PersonStream> list = List.of(
          new PersonStream("male", "1"),
          new PersonStream("female", "2"),
          new PersonStream("male", "3"),
          new PersonStream("male", "4"),
          new PersonStream("female", "5"),
          new PersonStream("male", "6"),
          new PersonStream("male", "7"),
          new PersonStream("female", "8"),
          new PersonStream("male", "9")
        );

        Map<String, List<PersonStream>> map = list.stream()
                .collect(groupingByConcurrent(PersonStream::getGender));
        map.forEach((key, value) -> System.out.println("key : " + key + ", value : " + value));
        System.out.println("==================");
        // 操作順序會是亂的
        List<Integer> intList1 = List.of(
          1,2,3,4,5,6,7,8,9
        );
        intList1.parallelStream().forEach(System.out::println);
        System.out.println("==================");
        // 按照操作順序
        intList1.parallelStream().forEachOrdered(System.out::println);
    }
}

@Getter
@Setter
@ToString
@AllArgsConstructor
class PersonStream{
    private String gender;
    private String number;
}
