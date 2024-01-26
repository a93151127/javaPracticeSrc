package lambda;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class EnforceStreamMain {
    public static void main(String[] args) {
        CustomerStream cus = new CustomerStream();

        // 舊的寫法
        Stream<String> mail = cus.getMainAddress() != null ? cus.getMainAddress().stream() : Stream.empty();
        mail.forEach(System.out::println);

        // Optional版本
        Stream<String> mail2 = Optional.of(cus)
                .map(customer -> customer.getMainAddress().stream())
                .orElse(Stream.empty());
        mail2.forEach(System.out::println);

        // java 9 以後的版本
        Stream<String> mail3 = Stream.ofNullable(cus)
                .flatMap(customer -> customer.getMainAddress().stream());
        mail3.forEach(System.out::println);
    }
}

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
class CustomerStream{
    private String email;
    public List<String> getMainAddress(){
        List<String> mailList = new ArrayList<>();
        if(this.email != null){
            mailList.add(this.email);
        }
        return mailList;
    }
}
