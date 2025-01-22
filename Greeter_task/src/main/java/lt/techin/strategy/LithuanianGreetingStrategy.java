package lt.techin.strategy;

public class LithuanianGreetingStrategy implements GreeterLanguageStrategy {

    public String getGreetingString() {
        return "Labas, ";
    }
}
