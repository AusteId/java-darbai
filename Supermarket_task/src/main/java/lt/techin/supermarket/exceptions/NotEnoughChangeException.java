package lt.techin.supermarket.exceptions;

public class NotEnoughChangeException extends RuntimeException {
    public NotEnoughChangeException(String message) {
        super(message);
    }
}
