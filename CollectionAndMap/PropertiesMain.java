package CollectionAndMap;

import java.util.Properties;

public class PropertiesMain {
    public static void main(String[] args) {
        Properties prop = System.getProperties();
        System.out.println(prop.getProperty("username"));
    }
}
