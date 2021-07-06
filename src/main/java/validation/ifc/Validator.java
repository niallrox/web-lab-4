package validation.ifc;

public interface Validator<T> {
    T validate(T t);
}
