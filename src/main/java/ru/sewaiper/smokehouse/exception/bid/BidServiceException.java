package ru.sewaiper.smokehouse.exception.bid;

public class BidServiceException extends Exception {
    private final int code;

    public BidServiceException(int code) {
        this(code, "");
    }

    public BidServiceException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public int getErrorCode() {
        return code;
    }
}