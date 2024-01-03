package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamPipeMain {
    public static void main(String[] args) {
        List<Player> list = List.of(
                new Player("Martin", 37, "male"),
                new Player("Abigail", 35, "female"),
                new Player("Welson", 18, "male")
        );
        // 將男女分組
        Map<String, List<Player>> map = list.stream()
                .collect(groupingBy(Player::getGender));
        map.forEach((key, value) -> System.out.println("key : " + key + ", value : " + value));

        // 將男女分組後取得名字
        Map<String, List<String>> nameMap = list.stream()
                .collect(groupingBy(Player::getGender,
                        mapping(Player::getName, toList())));
        nameMap.forEach((key, value) -> System.out.println("key : " + key + ", value : " + value));

        // 將男女分組後取得年齡加總
        Map<String, Integer> ageMap = list.stream()
                .collect(groupingBy(Player::getGender,
                        reducing(0, Player::getAge, Integer::sum)));
        ageMap.forEach((key, value) -> System.out.println("key : " + key + ", value : " + value));

        // 將男女分組後取得年齡平均
        Map<String, Double> averageMap = list.stream()
                .collect(groupingBy(Player::getGender,
                        averagingInt(Player::getAge)));
        averageMap.forEach((key, value) -> System.out.println("key : " + key + ", value : " + value));

        // 取得男生的名字並且用逗號分開
        String nameStr = list.stream()
                .filter(player -> player.getGender().equals("male"))
                .map(Player::getName)
                .collect(joining(","));
        System.out.println(nameStr);
    }
}

class Player{
    private String name;
    private Integer age;

    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public Player(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
