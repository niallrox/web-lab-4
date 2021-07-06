package service.impl;

import entity.Point;
import entity.User;
import exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import service.ifc.UserService;
import validation.ifc.Validator;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    //todo token

    private Validator<User> validator;
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        validator.validate(user);
        return null;
    }

    @Override
    public User authorize(User user) {
        Optional<User> byId = userRepository.findById(user.getLogin());
        if (!byId.isPresent()) throw new ResourceNotFoundException("This user not found");
        return byId.get();
    }

    @Override
    public List<Point> getAllPointsByUserId(String id) {
        return userRepository.findAllPointsByUserID(id);

    }

    @Override
    public void removeAllPoints(String id) {
        userRepository.removeAllPointsByUserID(id);
    }
}
