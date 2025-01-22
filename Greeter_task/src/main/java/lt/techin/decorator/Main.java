package lt.techin.decorator;

public class Main {
    public static void main(String[] args) {

        Greeter g = new GreeterImpl();
        g = new GreeterUpperCaseDecorator(new GreeterExclamationMarkDecorator(g));
        System.out.println(g.greet("ne", "me"));

    }
}
