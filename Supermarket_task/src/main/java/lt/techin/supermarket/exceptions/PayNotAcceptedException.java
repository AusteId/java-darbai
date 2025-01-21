package lt.techin.supermarket.exceptions;

public class PayNotAcceptedException extends RuntimeException {
    public PayNotAcceptedException(String message) {
        super(message);
    }
}
