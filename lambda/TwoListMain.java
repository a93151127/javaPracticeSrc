package lambda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TwoListMain {
    public static void main(String[] args) {
        List<AAA> aList = List.of(
                new AAA("TSPOINT", "0", "S0000"),
                new AAA("DJDZ001", "20", "S0000"),
                new AAA("DJDZ055", "100", "S0000"),
                new AAA("DJDZ100", "0", "E9002")
        );

        List<BBB> bList = List.of(
                new BBB("TSPOINT", "10", "S0000"),
                new BBB("DJDZ001", "10", "S0000"),
                new BBB("DJDZ055", "100", "S0000")
        );

        Map<String, String> bMap = bList.stream()
                .collect(Collectors.toMap(BBB::getPointId, BBB::getBalance));

        long sum = aList.stream()
                .filter(a -> a.getCode().equals("S0000") && !a.getPointId().equals("TSPOINT"))
                .mapToLong(a -> Long.parseLong(bMap.getOrDefault(a.getPointId(), a.getBalance())))
                .sum();

        System.out.println("sum : " + sum);
    }
}
@Getter
@Setter
@ToString
@AllArgsConstructor
class AAA {
    private String pointId;
    private String balance;
    private String code;
}
@Getter
@Setter
@ToString
@AllArgsConstructor
class BBB {
    private String pointId;
    private String balance;
    private String code;
}

