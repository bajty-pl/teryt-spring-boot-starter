package pl.bajty.teryt.exception;

public class TerytException extends RuntimeException {
    public TerytException(String message) { super(message); }
    public TerytException(String message, Throwable cause) { super(message, cause); }
}