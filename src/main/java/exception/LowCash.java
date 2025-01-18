package exception;

public class LowCash extends RuntimeException {
    public LowCash(String message) {
        super(message);
    }
}
