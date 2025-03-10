package lt.techin.strategy;

public class Greeter {

    private GreeterLanguageStrategy greeterLanguageStrategy;

    public Greeter(GreeterLanguageStrategy greeterLanguageStrategy) {
        this.greeterLanguageStrategy = greeterLanguageStrategy;
    }

    public void greet(String firstName, String lastName) {
        System.out.println(greeterLanguageStrategy.getGreetingString() + firstName + lastName);
    }

}
