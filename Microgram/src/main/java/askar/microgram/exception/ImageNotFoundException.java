package askar.microgram.exception;

public class ImageNotFoundException extends NotFoundEntryException {
    public ImageNotFoundException() {
        super("Image not found");
    }
}
