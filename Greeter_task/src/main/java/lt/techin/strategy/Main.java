package lt.techin.strategy;



public class Main {
    public static void main(String[] args) {
        Greeter g = new Greeter(new LithuanianGreetingStrategy());
        g.greet("A", "B");

        Greeter a = new Greeter(new EnglishGreetingStrategy());
        a.greet("a", "b");
    }
}
