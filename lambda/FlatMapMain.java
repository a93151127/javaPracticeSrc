package lambda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlatMapMain {
    public static void main(String[] args) {
        City c1 = new City("TaiPei");
        City c2 = new City("TaiNan");
        List<City> cList = List.of(c1, c2);
        CustomerTest ct1 = new CustomerTest(cList);
        Order o1 = new Order(ct1);

        City c3 = new City("HuaLian");
        City c4 = new City("TaiDong");
        List<City> cList2 = List.of(c3, c4);
        CustomerTest ct2 = new CustomerTest(cList2);
        Order o2 = new Order(ct2);

        List<Order> oList = List.of(o1, o2);
        judgeCustomer(oList).forEach(System.out::println);
    }

    private static List<String> judgeCustomer(List<Order> order) {
        return order.stream()
                .map(Order::getCustomer)
                .map(CustomerTest::getAddress)
                .flatMap(city -> city.stream())
                .map(City::getCityName)
                .collect(Collectors.toList());
//        return order.stream()
//                .collect(Collectors.flatMapping(
//                   customer -> customer.getCustomer().getAddress().stream(), Collectors.toList()
//                ))
//                .stream()
//                .map(City::getCityName)
//                .collect(Collectors.toList());
    }
}

@Getter
@Setter
@ToString
@AllArgsConstructor
class CustomerTest {
    private List<City> address;
}

@Getter
@Setter
@ToString
@AllArgsConstructor
class City {
    private String cityName;
}

@Getter
@Setter
@ToString
@AllArgsConstructor
class Order {
    private CustomerTest customer;
}
