package lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ThenCompareMain {
    public static void main(String[] args) {
        List<Customer> customers = Arrays.asList(
          new Customer("Martin", "Lu", "12345"),
          new Customer("Abigail", "Liu", "98765"),
          new Customer("Welson", "Chen", "54321")
        );

        Comparator<Customer> byLastName = Comparator.comparing(Customer::getLastName);

        customers.sort(byLastName
                .thenComparing(Customer::getFirstName)
                .thenComparing(Customer::getZipCode)
        );

        customers.forEach(System.out::println);
    }
}

class Customer{
    private String firstName;
    private String lastName;
    private String zipCode;

    public Customer(String firstName, String lastName, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
