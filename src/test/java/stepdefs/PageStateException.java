package stepdefs;

public class PageStateException extends Exception{

    public PageStateException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
