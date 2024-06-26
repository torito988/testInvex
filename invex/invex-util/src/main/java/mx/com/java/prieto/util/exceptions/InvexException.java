package mx.com.java.prieto.util.exceptions;


public class InvexException extends Exception {

    private static final long serialVersionUID = -6873529230413661726L;
    private static final String CAUSE_BY = "\nCause by: ";

    private final Throwable cause;

    public InvexException(String message) {
        super(message);
        this.cause = null;
    }

    public InvexException(Throwable cause) {
        super();
        this.cause = cause;
    }

    public InvexException(String message, Throwable cause) {
        super(message);
        this.cause = cause;
    }

    @Override
    public synchronized Throwable getCause() {
        return cause;
    }

    @Override
    public String toString() {
        if (cause == null) {
            return super.toString();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString()).append(CAUSE_BY).append(cause.toString());
            return sb.toString();
        }
    }
}
