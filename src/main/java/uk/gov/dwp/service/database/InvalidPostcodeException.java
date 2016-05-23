package uk.gov.dwp.service.database;

public class InvalidPostcodeException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public InvalidPostcodeException(String message) {
        super(message);
    }
}
