package askar.microgram.exception;

public class NotFoundEntryException extends RuntimeException {
    public NotFoundEntryException(String message) {
        super(message);
    }
}
