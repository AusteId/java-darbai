package lt.techin;

import lt.techin.strategy.LithuanianGreetingStrategy;
import lt.techin.template.EnglishGreeter;
import lt.techin.template.Greeter;
import lt.techin.template.LithuanianGreeter;

public class Main {
    public static void main(String[] args) {
        Greeter l = new LithuanianGreeter();
        l.greet("Va", "rdas");

        Greeter e = new EnglishGreeter();
        e.greet("Na", "me");

    }
}
