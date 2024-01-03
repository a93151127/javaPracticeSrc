package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ConstructorMain {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "Martin",
                "Abigail"
        );
        // 這邊修改 testNew 讓他的參數數量和返回值跟 Function 的 apply相同
        List<Person> strList = map(list, Person::testNew);
        strList.forEach(System.out::println);
    }

    static <P, R> List<R> map(List<P> list, Function<P, R> mapper){
        List<R> mapped = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            mapped.add(mapper.apply(list.get(i)));
        }
        return mapped;
    }
}

class Person{
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Person testNew(String name){
        Person person = new Person();
        person.setName(name);
        return person;
    }

}
