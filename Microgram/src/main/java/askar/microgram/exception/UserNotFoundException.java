package askar.microgram.exception;

public class UserNotFoundException extends NotFoundEntryException {
    public UserNotFoundException() {
        super("User not found: ");
    }
}
