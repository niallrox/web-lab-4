package validation.impl;

import entity.User;
import exception.ArgumentNotValidException;
import validation.ifc.Validator;

public class UserValidator implements Validator<User> {
    @Override
    public User validate(User user) {
        if (user.getLogin().length() < 6 ||
        user.getPassword().length() < 6) throw new ArgumentNotValidException("login and password length should be more than 5");
        return user;
    }
}
