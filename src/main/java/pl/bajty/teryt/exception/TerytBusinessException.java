package pl.bajty.teryt.exception;

public class TerytBusinessException extends TerytException {
    private final String faultCode; // np. "env:Client"

    public TerytBusinessException(String message, String faultCode) {
        super(message);
        this.faultCode = faultCode;
    }
    public String getFaultCode() { return faultCode; }
}