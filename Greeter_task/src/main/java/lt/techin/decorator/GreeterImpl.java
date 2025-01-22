package lt.techin.decorator;

public class GreeterImpl implements Greeter {
    @Override
    public String greet(String firstName, String lastName) {
        return "Hi, " + firstName + " " + lastName;
    }
}
