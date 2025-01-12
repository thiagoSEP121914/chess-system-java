package boardGame;

public class BoardException extends RuntimeException {
    private static final long SERIALVERSIONUID = 1L;

    public BoardException(String msg) {
        super(msg);
    }
}
