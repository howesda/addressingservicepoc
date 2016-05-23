package uk.gov.dwp.service.database;

public class InvalidUprnException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public InvalidUprnException(String message) {
        super(message);
    }
}
