package exception;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

public class ResourceNotFoundException extends ConstraintViolationException {
    public ResourceNotFoundException(String message) {
        super(message, null);
    }
}
